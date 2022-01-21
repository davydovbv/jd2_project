package by.academy.it.converter.topic;

import by.academy.it.dto.topic.TopicForSearchDto;
import by.academy.it.topic.pojo.Topic;
import org.springframework.stereotype.Component;

@Component
public class TopicForSearchDtoConverter {

    public TopicForSearchDto convert(Topic topic) {
        TopicForSearchDto topicForSearchDto = new TopicForSearchDto();
        topicForSearchDto.setCreatorId(topic.getAppUser().getId());
        topicForSearchDto.setCreatorName(topic.getAppUser().getFirstName() + " " + topic.getAppUser().getLastName());
        topicForSearchDto.setTheme(topic.getTheme());
        topicForSearchDto.setDescription(topic.getDescription());
        topicForSearchDto.setId(topic.getId());
        return topicForSearchDto;
    }
}
