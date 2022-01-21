package by.academy.it.topic;

import by.academy.it.dao.TopicMessageDao;
import by.academy.it.topic.pojo.TopicMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Transactional
public class TopicMessageDaoImpl implements TopicMessageDao {
    @Autowired
    @Qualifier("chattyDogSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public int save(TopicMessage topicMessage) {
        Session session = sessionFactory.getCurrentSession();
        Serializable messageId = session.save(topicMessage);
        return (int) messageId;
    }
}
