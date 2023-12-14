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
    @JsonProperty("userChat")
    private String userChat;
    @Builder
    public DateCourseRequest(int user_cost){
        this.userChat = userChat;
    }

    public String PlaceInfo(){
        return  "('카페', '삼다코지', '합정 카페거리에 위치한 삼다코지는 도심 속 제주를 컨셉으로한 대형카페', 8000원, '서울 마포구 독막로9길 34 1층', '11:00 ~ 23:00', 4.8), " +
                "('레스토랑', '틸에프터', '모던한 무드의 파스타 맛집', 14000원, '서울 마포구 양화로19길 22-30 1층', '11:30 ~ 21:30(15:00 ~ 17:00 브레이크 타임)', 5.0), " +
                "('이자카야', '홍대공감', '프리미엄 이자카야 수제요리 전문점', 45000원, '서울 마포구 와우산로17길 10 2F', '16:00 ~ 02:00', 4.7), " +
                "('공원', '망원한강공원', '한강을 바라볼 수 있는 아름다운 공원', 0원, '서울 마포구 망원로 321번지', '상시 개방', 4.8), " +
                "('영화관', 'CGV 연남', '다양한 영화를 감상할 수 있는 영화관', 14000원, '서울 마포구 양화로 186 LC타워 7층 CGV 연남', '영화 상영 시간에 따라 상이', 4.61), " +
                "('레스토랑', '델라인디아', '인도인이 직접 운영하는 퓨전 인도음식점', 15000원, '서울 마포구 독막로9길 8 2층', '11:00 ~ 22:30', 4.76), " +
                "('바', '어반루프 연남', '어반루프만의 시그니쳐 칵테일과 색다른 생맥주와 병맥주 그리고 가성비 좋은 와인이 준비되어 있는연남동 루프탑 바&라운지펍', 8000원, '서울 마포구 동교로38길 13 3층 어반루프', '17:00 ~ 03:00', 4.5), " +
                "('카페', '수상한 베이글', '멋진 정원과 맛있는 베이글이 있는 특별한 공간', 6000원, '서울 마포구 와우산로15길 22', '9:30 ~ 22:00', 5.0), " +
                "('한식집', '평화연남', '질 좋은 재료와 전골 스타일의 낙곱새를 트렌드로 이끈 매장', 35000원, '서울 마포구 동교로 254-1', '11:30 ~ 22:30(15:30 ~ 16:30 브레이크 타임)', 4.36), " +
                "('카페', '파이인더샵', '연남동 한적한 주택가 사이, 자연을 느낄 수 있는 곳 시그니처 라떼&파이 카페', 10000원, '서울 마포구 성미산로27길 26', '11:30 ~ 21:00', 4.4)" +
                "('카페', '하우에버 연남', '매일 매일 직접 굽는 신선한 30종의 디저트와 유니크 한 감성의 25종의 음료, 층마다 다른 색감과 컨셉의 편안한 공간', 4000원, '서울 마포구 연희로1길 45-6', '11:00 ~ 22:00', 4.9)" +
                "('일일 체험', '더클라임 클라이밍 짐앤샵 연남점', '암벽등반 체험을 할 수 있는 클라이밍 센터', 22000원, '서울 마포구 양화로 186 3층', '10:00 ~ 23:00', 4.8)" +
                "('쇼핑', '빈티바이로웰', '명품 / 스트릿 / 디자이너 브랜드 위주의 중고 제품', 5000원, '서울 마포구 양화로6길 66 지하 1층', '12:00 ~ 23:00', 4.8)" +
                "('한식집', '옥동식', '한식 맛집', 6000원, '서울 마포구 양화로7길 44-10', '11:00 ~ 22:00', 4.2)" +
                "('카페', '어더아사', '대용량 구슬아이스크림과 계절별로 다양한 소프트 아이스크림', 3000원, '서울 마포구 와우산로23길 40 1층 102호', '12:00 ~ 21:00', 5.0)" +
                "이것들은 장소 유형(place_type), 장소 이름(place_name), 장소 정보(place_intro), 가격(price), 위치(location), 오픈 시간(op_time), 별점(star_point) 순으로 나열된 리스트들이야";

    }

    public String toPromptString(){
        return "\"---\" 아래의 토픽에 대해 예를 들어줘."
               + "아래의 옵션들을 지켜줘."
               + "- Tone : 존댓말"
               + "- Style : 정확하게"
               + "- Reader level : 대학생"
               + "- Length : 제한 없음"
               + "- Perspective : 추천 전문가"
               + "- Format : 리스트"
               + "\"---\""
               + "넌 데이트 코스를 추천해주는 컨설턴트야. 사용자가 입력하는 금액인 " +userChat+ "을 토대로 데이트 코스를 생성해주되, 리스트에 있는 장소들로 가격에 맞게 매번 다르게 추천해줘야해 그리고 반드시!! 사용자가 입력한 금액 안으로 맞춰서 추천해야해(잔여 비용이 -가 되면 안돼)"
                + "'출력 형식' -> 장소 유형(place_type), 장소 이름(place_name), 장소 정보(place_intro), 가격(price), 위치(location), 오픈 시간(op_time), 별점(star_point) 순으로 장소를 보여주고 장소들을 이용해 데이트코스를 짜줘"
                //+ "데이트 코스에는 3가지의 장소가 포함된 데이트 코스를 추천해줘야해"
                + "또한, 코스를 선택하면 선택한 코스의 비용을 기존 사용자가 입력한 금액에 빼서 남은 금액을 입력해줘. 이때 형식은 \"잔여 비용: \" 이렇게 다른 문장없이 잔여 비용만 출력해줘 => 단, 반드시 잔여 비용 출력은 사용자가 다시 코스를 추천해달라했을시 그때 비용으로 다시 게산해야해"
                + "그리고 이후에 사용자가 잔여 비용으로 추가적인 장소 추천을 원하면 잔여 비용을 넘지 않는 장소선에서 임의로 추천해줘도 돼";
    }
}
