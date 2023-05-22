package com.nando.demochatGPT.service;

import com.nando.demochatGPT.client.ChatGptClient;
import com.nando.demochatGPT.config.ChatGPTConfig;
import com.nando.demochatGPT.model.ChatGptRequest;
import com.nando.demochatGPT.model.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final ChatGptClient chatGptClient;
    private final ChatGPTConfig chatGPTConfig;

    public void getWorkout(List<String> bodyPart) {
        String prompt = String.format(chatGPTConfig.getWorkoutTemplate(), massageBodyPartInput(bodyPart));
        log.debug("Question: {}", prompt);
        ChatGptRequest request = new ChatGptRequest("text-davinci-001", prompt, 1, 100);
        ChatGptResponse response = chatGptClient.searchForMealPlan(request);
        log.info(response.choices()[0].text());

    }

    private String massageBodyPartInput(List<String> bodyPart) {
        var sanitizeBodyParts = sanitizeList(bodyPart);
        var rutineTemplate = "";
        if (sanitizeBodyParts.size() > 1 && !sanitizeBodyParts.contains("FULL BODY")) {
            rutineTemplate = sanitizeBodyParts.stream().collect(Collectors.joining(","));
        } else {
            rutineTemplate = bodyPart.get(0);
        }
        log.debug("body parts: {}", rutineTemplate);
        return rutineTemplate;
    }

    private List<String> sanitizeList(List<String> partsOfTheBody) {
        return partsOfTheBody
                .stream()
                .map(b -> b.toUpperCase())
                .toList();
    }
}
