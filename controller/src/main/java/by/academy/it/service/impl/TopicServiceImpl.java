package by.academy.it.service.impl;

import by.academy.it.converter.topic.TopicCreateDtoToTopicConverter;
import by.academy.it.converter.topic.TopicForSearchDtoConverter;
import by.academy.it.converter.topic.TopicPageDtoConverter;
import by.academy.it.dao.TopicDao;
import by.academy.it.dto.topic.TopicCreateDto;
import by.academy.it.dto.topic.TopicForSearchDto;
import by.academy.it.dto.topic.TopicPageDto;
import by.academy.it.exceptions.ContentNotFoundException;
import by.academy.it.service.TopicService;
import by.academy.it.service.UserService;
import by.academy.it.topic.pojo.Topic;
import by.academy.it.topic.pojo.TopicMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDao topicDao;

    @Autowired
    private TopicForSearchDtoConverter topicForSearchDtoConverter;

    @Autowired
    private TopicCreateDtoToTopicConverter topicCreateDtoToTopicConverter;

    @Autowired
    private TopicPageDtoConverter topicPageDtoConverter;

    @Autowired
    private UserService userService;


    @Override
    @Transactional
    public int createTopic(TopicCreateDto topicCreateDto, int creatorId) {
        Topic topic = topicCreateDtoToTopicConverter.convert(topicCreateDto);
        topic.setAppUser(userService.findUserById(creatorId));
        return topicDao.save(topic);
    }

    @Override
    @Transactional
    public List<TopicForSearchDto> findAllTopics() {
            return topicDao.getAllTopics().stream()
                    .map(topic -> topicForSearchDtoConverter.convert(topic))
                    .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TopicPageDto getTopicDtoByTopicId(int topicId) {
        Topic topic = getTopicById(topicId);
        if (topic == null) {
            throw new IllegalArgumentException("Topic with id: " + topicId + "doesn't exist");
        }
        List<TopicMessage> sorted= topic.getMessages();
        if(sorted != null) {
            sorted.sort(Comparator.comparing(TopicMessage::getCreated));
            Collections.reverse(sorted);
            topic.setMessages(sorted);
        }
        return topicPageDtoConverter.convert(topic);
    }

    @Override
    @Transactional
    public Topic getTopicById(int topicId) {
        Topic topic = topicDao.findTopicById(topicId);
        if (topic == null) {
            throw new ContentNotFoundException("Topic with id: " + topicId + "doesn't exist");
        }
        return topic;
    }

    @Override
    @Transactional
    public boolean showAddToFavoriteButton(int topicId, int userId) {
        Topic topicById = getTopicById(topicId);
        if (userId == 0) {
            return false;
        }
        if (topicById.getAppUser().getId() != userId){
            List<Topic> usersFavoriteTopics = userService.getUsersFavoriteTopics(userId);
            return !usersFavoriteTopics.contains(topicById);
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean showRemoveFromFavoriteButton(int topicId, int userId) {
        Topic topicById = getTopicById(topicId);
        if (userId == 0) {
            return false;
        }
        if (topicById.getAppUser().getId() != userId){
            List<Topic> usersFavoriteTopics = userService.getUsersFavoriteTopics(userId);
            return usersFavoriteTopics.contains(topicById);
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public void deleteTopic(int topicId, int userId) {
        Topic topic = getTopicById(topicId);
        topic.setDeleted(true);
        topicDao.deleteTopic(topic);
    }
}
