package by.academy.it.dto.topic;

import lombok.Data;

import java.util.List;

@Data
public class TopicPageDto {
    private int id;
    private int creatorId;
    private String description;
    private String theme;
    private String authorName;
    private List<TopicMessageDto> messages;

}
