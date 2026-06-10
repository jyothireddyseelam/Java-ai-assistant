package com.eazybytes.eazystore.service;

import com.eazybytes.eazystore.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final ChatClient chatClient;

    public AIService(ChatClient.Builder builder) {

        this.chatClient = builder
                .defaultSystem("""
                        You are an experienced Java trainer.

                        Help students understand:
                        - Core Java
                        - OOP Concepts
                        - Java Streams
                        - Lambda Expressions
                        - Collections Framework
                        - Exception Handling
                        - Multithreading
                        - Spring Boot Basics

                        Explain concepts clearly for beginners.
                        """)
                .build();
    }

    public ChatResponse getAnswer(String topic) {

        String prompt = """
Explain Java %s.

Return response in exactly this format.
Do NOT use markdown.
Do NOT use ### symbols.

Definition: <definition>

WhyUsed: <why used>

Example: <example>

InterviewQuestion: <question>
""".formatted(topic);

        String aiResponse = chatClient.prompt()
                .user(prompt)
                .call()
                .content();

        String definition = "";
        String whyUsed = "";
        String example = "";
        String interviewQuestion = "";
        System.out.println(aiResponse);
        String[] sections = aiResponse.split("\n\n");
        for (String section : sections) {

            if (section.startsWith("Definition:")) {
                definition = section.replace("Definition:", "").trim();
            }

            else if (section.startsWith("WhyUsed:")) {
                whyUsed = section.replace("WhyUsed:", "").trim();
            }

            else if (section.startsWith("Example:")) {
                example = section.replace("Example:", "").trim();
            }

            else if (section.startsWith("InterviewQuestion:")) {
                interviewQuestion =
                        section.replace("InterviewQuestion:", "").trim();
            }
        }



        return new ChatResponse(
                definition,
                whyUsed,
                example,
                interviewQuestion
        );
    }
}