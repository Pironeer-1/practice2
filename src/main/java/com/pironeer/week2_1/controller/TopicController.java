package com.pironeer.week2_1.controller;

import com.pironeer.week2_1.dto.request.TopicCreateRequest;
import com.pironeer.week2_1.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping("/api/topic")
    public ResponseEntity<?> create(@RequestBody TopicCreateRequest request) {
        topicService.save(request);
        return ResponseEntity.ok().build();
    }
}
