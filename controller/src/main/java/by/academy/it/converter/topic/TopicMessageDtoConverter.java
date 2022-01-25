package by.academy.it.converter.topic;

import by.academy.it.dto.topic.TopicMessageDto;
import by.academy.it.topic.pojo.TopicMessage;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class TopicMessageDtoConverter {
    public TopicMessageDto convert (TopicMessage topicMessage) {
        TopicMessageDto topicMessageDto = new TopicMessageDto();
        topicMessageDto.setContent(topicMessage.getContent());
        topicMessageDto.setAuthorId(topicMessage.getAuthor().getId());
        topicMessageDto.setAuthorName(topicMessage.getAuthor().getFirstName() + " " + topicMessage.getAuthor().getLastName());
        topicMessageDto.setCreated(topicMessage.getCreated().format(DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss")));
        return topicMessageDto;
    }
}
