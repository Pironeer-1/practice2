package com.pironeer.week2_1.repository.domain;

import com.pironeer.week2_1.dto.request.TopicUpdateRequest;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Topic {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Topic(
            Long id,
            String title,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Topic update(TopicUpdateRequest request) {
        updateTitle(request.title());
        updateContent(request.content());
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    private void updateTitle(String title) {
        if (title != null && !title.isBlank()) {
            this.title = title;
        }
    }

    private void updateContent(String content) {
        if (content != null && !content.isBlank()) {
            this.content = content;
        }
    }
}
