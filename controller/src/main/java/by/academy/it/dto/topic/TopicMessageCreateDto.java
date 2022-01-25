package by.academy.it.dto.topic;

import lombok.Data;

@Data
public class TopicMessageCreateDto {
    private String content;
    private int authorId;
    private int topicId;
}
