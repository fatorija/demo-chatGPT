package com.nando.demochatGPT.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "chat-gpt")
@Data
public class ChatGPTConfig {
    private String baseUrl;
    private String key;
    private String mealTemplate;

    private String workoutTemplate;
}
