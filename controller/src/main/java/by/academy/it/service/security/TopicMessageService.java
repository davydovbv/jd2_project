package by.academy.it.service.security;

import by.academy.it.dto.topic.TopicMessageCreateDto;

public interface TopicMessageService {
    int save(TopicMessageCreateDto topicMessageCreateDto);
}
