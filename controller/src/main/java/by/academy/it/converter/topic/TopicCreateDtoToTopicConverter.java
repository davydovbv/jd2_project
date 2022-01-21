package by.academy.it.converter.topic;

import by.academy.it.dto.topic.TopicCreateDto;
import by.academy.it.topic.pojo.Topic;
import org.springframework.stereotype.Component;

@Component
public class TopicCreateDtoToTopicConverter {
    public Topic convert(TopicCreateDto topicCreateDto) {
        Topic topic = new Topic();
        topic.setTheme(topicCreateDto.getTheme());
        topic.setDescription(topicCreateDto.getDescription());
        return topic;
    }
}
