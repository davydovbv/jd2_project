package by.academy.it.converter.topic;

import by.academy.it.dto.topic.TopicMessageDto;
import by.academy.it.dto.topic.TopicPageDto;
import by.academy.it.topic.pojo.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TopicPageDtoConverter {
    @Autowired
    TopicMessageDtoConverter topicMessageDtoConverter;

    public TopicPageDto convert(Topic topic) {
        TopicPageDto topicPageDto = new TopicPageDto();
        topicPageDto.setId(topic.getId());
        topicPageDto.setCreatorId(topic.getAppUser().getId());
        topicPageDto.setDescription(topic.getDescription());
        topicPageDto.setTheme(topic.getTheme());
        topicPageDto.setAuthorName(topic.getAppUser().getFirstName() + " " + topic.getAppUser().getLastName());
        List<TopicMessageDto> topicMessagesDto = topic.getMessages().stream()
                .map(message -> topicMessageDtoConverter.convert(message))
                .collect(Collectors.toList());
        topicPageDto.setMessages(topicMessagesDto);
        return topicPageDto;
    }
}
