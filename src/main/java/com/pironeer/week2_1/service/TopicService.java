package com.pironeer.week2_1.service;

import com.pironeer.week2_1.dto.request.TopicCreateRequest;
import com.pironeer.week2_1.dto.response.TopicResponse;
import com.pironeer.week2_1.repository.TopicRepository;
import com.pironeer.week2_1.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public void save(TopicCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        Topic topic = Topic.builder()
                        .title(request.title())
                        .content(request.content())
                        .createdAt(now)
                        .updatedAt(now)
                        .build();
        topicRepository.save(topic);
    }

    public TopicResponse findById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        return TopicResponse.of(topic);
    }

    public List<TopicResponse> findAll() {
        List<Topic> topics = topicRepository.findAll();
        return topics.stream().map(TopicResponse::of).toList();
    }
}
