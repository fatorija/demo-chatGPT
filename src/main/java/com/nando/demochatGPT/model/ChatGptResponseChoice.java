package com.nando.demochatGPT.model;

public record ChatGptResponseChoice(String text, int index, Object logprobs, String finish_reason) {
}
