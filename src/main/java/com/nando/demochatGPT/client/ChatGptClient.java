package com.nando.demochatGPT.client;

import com.nando.demochatGPT.model.ChatGptRequest;
import com.nando.demochatGPT.model.ChatGptResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface ChatGptClient {
    @PostExchange
    ChatGptResponse searchForMealPlan(@RequestBody ChatGptRequest request);
}
