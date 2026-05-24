package com.eazybytes.eazystore.controller;


import com.eazybytes.eazystore.dto.ChatRequest;
import com.eazybytes.eazystore.dto.ChatResponse;
import com.eazybytes.eazystore.service.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/java/chat")
@CrossOrigin(origins = "*")
public class ChatAIController {

    private final AIService aiService;

       public ChatAIController(AIService aiService){

           this.aiService = aiService;
       }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String response = aiService.getAnswer(request.message());
        return new ChatResponse(response);
    }

}
