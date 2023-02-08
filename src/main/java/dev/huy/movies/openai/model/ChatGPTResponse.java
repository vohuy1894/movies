package dev.huy.movies.openai.model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Data
public class ChatGPTResponse implements Serializable{
    private String id;
    private String object;
    private String model;
    private LocalDate created;
    private List<Choice> choices;
}
