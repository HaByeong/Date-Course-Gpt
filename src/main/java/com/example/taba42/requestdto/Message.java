package com.example.taba42.requestdto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Message implements Serializable {
    private String role;
    private String content;

    @Builder
    public Message(String role, String content){
        this.role = role;
        this.content = content;
    }
}
