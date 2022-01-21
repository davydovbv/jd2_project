package by.academy.it.dto.topic;

import lombok.Data;

@Data
public class TopicForSearchDto {
    private int id;
    private String theme;
    private String description;
    private String creatorName;
    private int creatorId;
}
