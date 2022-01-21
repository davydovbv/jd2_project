package by.academy.it.service.impl;

import by.academy.it.converter.topic.TopicMessageCreateDtoTopicMessageConverter;
import by.academy.it.dao.TopicMessageDao;
import by.academy.it.dto.topic.TopicMessageCreateDto;
import by.academy.it.service.TopicService;
import by.academy.it.service.UserService;
import by.academy.it.service.security.TopicMessageService;
import by.academy.it.topic.pojo.TopicMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicMessageServiceImpl implements TopicMessageService {
    @Autowired
    TopicMessageDao topicMessageDao;

    @Autowired
    TopicMessageCreateDtoTopicMessageConverter topicMessageCreateDtoTopicMessageConverter;

    @Autowired
    UserService userService;

    @Autowired
    TopicService topicService;

    @Override
    @Transactional
    public int save(TopicMessageCreateDto topicMessageCreateDto) {
        TopicMessage topicMessage = topicMessageCreateDtoTopicMessageConverter.convert(topicMessageCreateDto);
        topicMessage.setAuthor(userService.findUserById(topicMessageCreateDto.getAuthorId()));
        topicMessage.setTopic(topicService.getTopicById(topicMessageCreateDto.getTopicId()));
        return topicMessageDao.save(topicMessage);
    }
}
