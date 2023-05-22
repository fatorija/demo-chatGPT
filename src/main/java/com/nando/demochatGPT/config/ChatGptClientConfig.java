package com.nando.demochatGPT.config;

import com.nando.demochatGPT.client.ChatGptClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class ChatGptClientConfig {

    private final ChatGPTConfig chatGPTConfig;

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory() {
        WebClient client = WebClient
                .builder()
                .baseUrl(chatGPTConfig.getBaseUrl())
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization","Bearer " + chatGPTConfig.getKey())
                .build();

        return HttpServiceProxyFactory
                .builder(WebClientAdapter
                        .forClient(client)).build();
    }

    @Bean
    public ChatGptClient youTubeDataClient(HttpServiceProxyFactory factory) {
        return factory.createClient(ChatGptClient.class);
    }
}
