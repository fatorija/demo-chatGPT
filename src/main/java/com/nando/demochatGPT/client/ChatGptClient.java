package com.nando.demochatGPT.client;

import com.nando.demochatGPT.model.ChatGptRequest;
import com.nando.demochatGPT.model.ChatGptResponse;
import com.nando.demochatGPT.model.ChatGptResponseChoice;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface ChatGptClient {
    @PostExchange
    @RegisterReflectionForBinding({ChatGptResponse.class, ChatGptResponseChoice.class})
    ChatGptResponse searchForMealPlan(@RequestBody ChatGptRequest request);
}
