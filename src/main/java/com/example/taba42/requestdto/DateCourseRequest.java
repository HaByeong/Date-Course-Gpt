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
                + "비용은 : "+ userchat + "이야. 해당 비용을 토대로 데이트 코스를 생성해주되, 장소 유형(place_type), 장소 이름(place_name), 장소 정보(place_intro), 가격(price)," +
                " 위치(location), 오픈 시간(op_time), 별점(star_point) 순으로 1번, 2번, 3번 총 3가지를 추천하고 추천한걸 표로 작성해주고, 타입은 json값으로 /, 그리고 줄바꿈 없이 깔끔하게 알려줘. 아래와 같은 형식으로 출력해줘. 한국어로 알려줘" +
                "\n {"+
                "“date_course”: [{\n" +
                "              “priority“: 1,\n" +
                "              “place_type“: ,\n" +
                "              “place_name”: ,\n" +
                "              “place_intro“: ,\n" +
                "              “price“: ,\n" +
                "              “location”: ,\n" +
                "              “op_time“: ,\n" +
                "              “star_point”: \n" +
                "           },\n" +
                "           {\n" +
                "              “priority“: 2,\n" +
                "              “place_type“: ,\n" +
                "              “place_name”: ,\n" +
                "              “place_intro“: ,\n" +
                "              “price“: ,\n" +
                "              “location”: ,\n" +
                "              “op_time“: ,\n" +
                "              “star_point”: \n" +
                "           },\n" +
                "           {\n" +
                "              “priority“: 3,\n" +
                "              “place_type“: ,\n" +
                "              “place_name”: ,\n" +
                "              “place_intro“ :,\n" +
                "              “price“: ,\n" +
                "              “location”: ,\n" +
                "              “op_time“: ,\n" +
                "              “star_point”: \n" +
                "           }\n" +
                "        ]\n" +
                "     }`;";
    }
}
