package by.academy.it.chat;

import by.academy.it.chat.pojo.PrivateMessage;
import by.academy.it.dao.PrivateMessageDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Transactional
public class PrivateMessageDaoImpl implements PrivateMessageDao {

    @Autowired
    @Qualifier("chattyDogSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public int save(PrivateMessage privateMessage) {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(privateMessage);
        return (int) id;
    }
}
