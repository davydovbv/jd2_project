package by.academy.it.service;

import by.academy.it.dto.topic.TopicCreateDto;
import by.academy.it.dto.topic.TopicForSearchDto;
import by.academy.it.dto.topic.TopicPageDto;
import by.academy.it.topic.pojo.Topic;

import java.util.List;

public interface TopicService {
    int createTopic(TopicCreateDto topicCreateDto, int creatorId);

    List<TopicForSearchDto> findAllTopics();

    TopicPageDto getTopicDtoByTopicId(int topicId);

    Topic getTopicById(int topicId);

    boolean showAddToFavoriteButton(int topicId, int userId);

    boolean showRemoveFromFavoriteButton(int topicId, int userId);

    void deleteTopic(int topicId, int userId);
}
