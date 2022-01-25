package by.academy.it.dto.topic;

import lombok.Data;

@Data
public class TopicMessageDto {
    private String content;
    private String authorName;
    private int authorId;
    private String created;
}
