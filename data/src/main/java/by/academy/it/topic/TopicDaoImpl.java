package by.academy.it.topic;

import by.academy.it.dao.TopicDao;
import by.academy.it.topic.pojo.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class TopicDaoImpl implements TopicDao {
    @Autowired
    @Qualifier("chattyDogSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public int save(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        Serializable topicId = session.save(topic);
        return (int)topicId;
    }

    @Override
    public List<Topic> getAllTopics() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Topic where deleted = false", Topic.class)
                .list();
    }

    @Override
    public Topic findTopicById(int topicId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Topic.class, topicId);
    }

    @Override
    public void deleteTopic(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.update(topic);
    }
}
