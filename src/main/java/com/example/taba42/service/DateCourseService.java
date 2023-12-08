package com.example.taba42.service;

import com.example.taba42.config.ChatGptConfig;
import com.example.taba42.requestdto.ChatGptRequest;
import com.example.taba42.requestdto.DateCourseRequest;
import com.example.taba42.requestdto.Message;
import com.example.taba42.responsedto.ChatGptResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DateCourseService {
    private static RestTemplate restTemplate = new RestTemplate();
    private List<Message> messages = new ArrayList<>();

    // 첫 번째 메시지 설정
    // Constructor
    public DateCourseService() {
        // 첫 번째 메시지 설정
        Message firstMessage = Message.builder()
                .role("assistant")
                .content(new DateCourseRequest().toPromptString())
                .build();
        messages.add(firstMessage);
    }

    //Gpt 설정 바디 및 헤더 HttpEntity를 만듬
    public HttpEntity<ChatGptRequest> createHttpEntity(ChatGptRequest chatGptRequest){
        String token = System.getenv("BEARER_TOKEN");
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer " +token);
        return new HttpEntity<>(chatGptRequest, headers);
    }

    //GPT에 POST 요청 보내고 받은 앤티티의 body 부분 return
    public ChatGptResponse getResponse(HttpEntity<ChatGptRequest> chatGptRequest){
        ResponseEntity<ChatGptResponse> responseEntity = restTemplate.postForEntity(
                ChatGptConfig.URL,
                chatGptRequest,
                ChatGptResponse.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }
        //예외처리 해줘야함 근데 아직 구현X
        else {
            System.err.println("API 요청 실패 " + responseEntity.getStatusCode());
            return responseEntity.getBody();
        }
    }

    public ChatGptResponse askQuestionToChatGpt(DateCourseRequest dateCourseRequest) {
        Message message = Message.builder()
                .role("user")
                .content(String.valueOf(dateCourseRequest.getUser_cost()))  // int를 String으로 변환
                .build();
        messages.add(message);

        ChatGptResponse response = this.getResponse(
                this.createHttpEntity(
                        ChatGptRequest.builder()
                                .model(ChatGptConfig.MODEL)
                                .messages(new ArrayList<>(messages))  // 이전 대화 내용을 함께 전달
                                .maxTokens(ChatGptConfig.MAX_TOKEN)
                                .temperature(ChatGptConfig.TEMPERATURE)
                                .topP(ChatGptConfig.TOP_P)
                                .build()));

        // GPT의 응답을 messages 리스트에 추가
        messages.add(Message.builder().role("assistant").content(response.getChoices().get(0).getMessage().getContent()).build());

        return response;
    }
    public void resetConversation() {
        Message firstMessage = messages.get(0);
        this.messages.clear();
        this.messages.add(firstMessage);
    }

}