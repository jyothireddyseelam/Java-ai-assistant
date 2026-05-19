package com.eazybytes.eazystore.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final  ChatClient chatClient;

  public AIService(ChatClient.Builder builder){
      this.chatClient = builder
              .defaultSystem("""
                You are a GIS and Remote Sensing expert.
                
                Help students understand:
                - GIS
                - LiDAR
                - DEM
                - DSM
                - Remote Sensing
                - Spatial Analysis
                - Mapping
                
                Explain concepts clearly for beginners.
                """)
              .build();
  }
  public String getAnswer(String question){
      return chatClient.prompt()
      .user(question)
              .call()
              .content();
  }

}
