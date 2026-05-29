package com.eazybytes.eazystore.service;

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

    public String getAnswer(String topic) {

        String prompt = """
                Explain Java %s.

                Include:
                1. Definition
                2. Why it is used
                3. Simple Example
                4. Common Interview Question

                Keep the explanation beginner friendly.
                """.formatted(topic);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}