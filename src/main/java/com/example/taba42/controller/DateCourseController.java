package com.example.taba42.controller;

import com.example.taba42.service.DateCourseService;
import com.example.taba42.requestdto.DateCourseRequest;
import com.example.taba42.responsedto.ChatGptResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/date")
public class DateCourseController {
    private final DateCourseService dateCourseService;

    @Autowired
    public DateCourseController(DateCourseService dateCourseService){
        this.dateCourseService = dateCourseService;
    }

    @PostMapping("/course")
    public ResponseEntity<ChatGptResponse> makeDateCourse(@RequestBody DateCourseRequest dateCourseRequest){
        log.info("Chat GPT의 데이트 코스 : {}",dateCourseRequest.toPromptString());
        return ResponseEntity.ok(dateCourseService.askQuestionToChatGpt(dateCourseRequest));
    }

    @GetMapping("/test")
    public ResponseEntity<String> getDateCourse() {

        return ResponseEntity.ok("GET 요청이 성공적으로 처리되었습니다.");
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetConversation() {
        dateCourseService.resetConversation();
        return ResponseEntity.ok("대화가 초기화되었습니다.");
    }
}
