package dev.huy.movies.openai;


import dev.huy.movies.openai.model.ChatGPTRequest;
import dev.huy.movies.openai.model.ChatGPTResponse;
import dev.huy.movies.openai.model.OpenAIRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/code-completion")
@RequiredArgsConstructor
public class OpenAIController {
    private final OpenAIService openAIService;
    @PostMapping("/send")
    public ChatGPTResponse sendMessage(@RequestBody OpenAIRequest openAIRequest){
        return openAIService.askQuestion(openAIRequest);
    }
}
