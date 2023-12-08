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

    //Gpt 설정 바디 및 헤더 HttpEntity를 만듬
    public HttpEntity<ChatGptRequest> createHttpEntity(ChatGptRequest chatGptRequest){
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer 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");
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
                .role("assistant")
                .content(dateCourseRequest.toPromptString())
                .build();
        List<Message> messages = new ArrayList<>();
        messages.add(message);
        return this.getResponse(
                this.createHttpEntity(
                        ChatGptRequest.builder()
                                .model(ChatGptConfig.MODEL)
                                //.prompt(dateCourseRequest.toPromptString())
                                .messages(messages)
                                .maxTokens(ChatGptConfig.MAX_TOKEN)
                                .temperature(ChatGptConfig.TEMPERATURE)
                                .topP(ChatGptConfig.TOP_P)
                                .build()));
    }

}
