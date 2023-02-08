package dev.huy.movies.openai.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class OpenAIRequest implements Serializable {
    private String message;
}
