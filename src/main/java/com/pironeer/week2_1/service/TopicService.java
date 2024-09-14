package com.pironeer.week2_1.service;

import com.pironeer.week2_1.dto.request.TopicCreateRequest;
import com.pironeer.week2_1.repository.TopicRepository;
import com.pironeer.week2_1.repository.domain.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public void save(TopicCreateRequest request) {
        Topic topic = Topic.builder()
                        .title(request.title())
                                .content(request.content())
                                        .build();
        topicRepository.save(topic);
    }
}
