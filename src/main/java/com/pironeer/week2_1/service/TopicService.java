package com.pironeer.week2_1.service;

import com.pironeer.week2_1.dto.request.TopicCreateRequest;
import com.pironeer.week2_1.dto.request.TopicUpdateRequest;
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

    public TopicResponse update(TopicUpdateRequest request) {
        Topic topic = topicRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        updateTitle(request.title(), topic);
        updateContent(request.content(), topic);
        topic.setUpdatedAt(LocalDateTime.now());
        topicRepository.save(topic);
        return TopicResponse.of(topic);
    }

    private static void updateTitle(String title, Topic topic) {
        if (title != null && !title.isBlank()) {
            topic.setTitle(title);
        }
    }

    private static void updateContent(String content, Topic topic) {
        if (content != null && !content.isBlank()) {
            topic.setContent(content);
        }
    }
}
