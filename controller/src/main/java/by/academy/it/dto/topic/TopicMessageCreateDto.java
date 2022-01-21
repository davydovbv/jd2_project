package by.academy.it.dto.topic;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TopicMessageCreateDto {
    private String content;
    private int authorId;
    private int topicId;
}
