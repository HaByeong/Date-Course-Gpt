package com.example.taba42.requestdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChatGptRequest implements Serializable{
    private String model;
    //private String prompt;
    @JsonProperty("max_tokens")
    private Integer maxTokens;
    private Double temperature;
    @JsonProperty("top_p")
    private Double topP;
    private List<Message> messages;

    @Builder
    public ChatGptRequest(String model, String prompt, Integer maxTokens, Double temperature, Double topP, List<Message> messages) {
        this.model = model;
        //this.prompt = prompt;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
        this.topP = topP;
        this.messages = messages;
    }
}
