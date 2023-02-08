package dev.huy.movies.openai;

import dev.huy.movies.openai.model.ChatGPTRequest;
import dev.huy.movies.openai.model.ChatGPTResponse;
import dev.huy.movies.openai.model.OpenAIRequest;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OpenAIServiceImpl implements OpenAIService{

    private static RestTemplate restTemplate = new RestTemplate();
    public HttpEntity<ChatGPTRequest> buildHttpEntity(ChatGPTRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(OpenAIConfig.MEDIA_TYPE));
        headers.add(OpenAIConfig.AUTHORIZATION, OpenAIConfig.BEARER + OpenAIConfig.API_KEY);
        return new HttpEntity<>(chatRequest, headers);
    }

    public ChatGPTResponse getResponse(HttpEntity<ChatGPTRequest> chatRequestHttpEntity) {
        ResponseEntity<ChatGPTResponse> responseEntity = restTemplate.postForEntity(
                OpenAIConfig.URL,
                chatRequestHttpEntity,
                ChatGPTResponse.class);

        return responseEntity.getBody();
    }

    @Override
    public ChatGPTResponse askQuestion(OpenAIRequest openAIRequest) {
        return this.getResponse(
                this.buildHttpEntity(
                        new ChatGPTRequest(
                                OpenAIConfig.MODEL,
                                openAIRequest.getMessage(),
                                OpenAIConfig.TEMPERATURE,
                                OpenAIConfig.MAX_TOKEN,
                                OpenAIConfig.TOP_P
                        )
                )
        );
    }
}
