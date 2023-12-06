package com.example.taba42.requestdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.taba42.responsedto.ChatGptResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class DateCourseRequest implements Serializable{
    @JsonProperty("userchat")
    private String userchat;
    @Builder
    public DateCourseRequest(String userchat){
        this.userchat = userchat;
    }

    public String toPromptString(){
        return "너는 지금부터 사용자가 적어준 비용을 토대로 데이트 코스 3가지를 추천해야해\n"
                + userchat + " 위 비용을 토대로 데이트 코스를 추천해주고 남은 비용도 출력해줘";
    }
}
