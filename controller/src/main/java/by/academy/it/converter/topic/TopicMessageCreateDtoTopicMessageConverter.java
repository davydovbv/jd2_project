package by.academy.it.converter.topic;

import by.academy.it.dto.topic.TopicMessageCreateDto;
import by.academy.it.topic.pojo.TopicMessage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TopicMessageCreateDtoTopicMessageConverter {
    public TopicMessage convert(TopicMessageCreateDto topicMessageCreateDto) {
        TopicMessage topicMessage = new TopicMessage();
        topicMessage.setCreated(LocalDateTime.now());
        topicMessage.setContent(topicMessageCreateDto.getContent());
        return topicMessage;
    }
}
