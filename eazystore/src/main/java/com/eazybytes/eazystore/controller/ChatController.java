package com.eazybytes.eazystore.controller;



import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("""
                You are a helpful healthcare assistant. 
                Answer questions about health, medical terms, 
                appointments, and general wellness clearly 
                and professionally. Always recommend 
                consulting a doctor for serious concerns.
                """)
                .build();
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String response = chatClient.prompt()
                .user(request.message())
                .call()
                .content();
        return new ChatResponse(response);
    }
}

record ChatRequest(String message) {}
record ChatResponse(String response) {}