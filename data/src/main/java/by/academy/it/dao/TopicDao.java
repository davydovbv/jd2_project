package by.academy.it.dao;

import by.academy.it.topic.pojo.Topic;

import java.util.List;

public interface TopicDao {

    int save(Topic topic);

    List<Topic> getAllTopics();

    Topic findTopicById(int topicId);

    void deleteTopic(Topic topic);
}
