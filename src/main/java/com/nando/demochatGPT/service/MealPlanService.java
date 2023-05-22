package com.nando.demochatGPT.service;

import com.nando.demochatGPT.client.ChatGptClient;
import com.nando.demochatGPT.config.ChatGPTConfig;
import com.nando.demochatGPT.model.ChatGptRequest;
import com.nando.demochatGPT.model.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
//@Log4j2
@RequiredArgsConstructor
public class MealPlanService {

    private final ChatGptClient chatGptClient;
    private final ChatGPTConfig chatGPTConfig;

    public void getMealPlan(Integer maxCalories) {
        String prompt = String.format(chatGPTConfig.getMealTemplate(), maxCalories);
        ChatGptRequest request = new ChatGptRequest("text-davinci-001", prompt, 1, 100);
        ChatGptResponse response = chatGptClient.searchForMealPlan(request);
//        log.info(response.choices()[0].text());
    }
}