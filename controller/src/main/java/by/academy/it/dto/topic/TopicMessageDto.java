package by.academy.it.dto.topic;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TopicMessageDto {
    private String content;
    private String authorName;
    private int authorId;
    private LocalDateTime created;
}
