package dev.huy.movies.openai;

import dev.huy.movies.openai.model.ChatGPTResponse;
import dev.huy.movies.openai.model.OpenAIRequest;

public interface OpenAIService {
    ChatGPTResponse askQuestion(OpenAIRequest openAIRequest);
}
