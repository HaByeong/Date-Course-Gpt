package com.example.taba42.responsedto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.taba42.requestdto.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
public class Choice implements Serializable {
    private Message message;
    private Integer index;
    @JsonProperty("finish_reason")
    private String finishReason;

    @Builder
    public Choice(Message message, Integer index, String finishReason){
        this.message = message;
        this.index = index;
        this.finishReason = finishReason;
    }
}
