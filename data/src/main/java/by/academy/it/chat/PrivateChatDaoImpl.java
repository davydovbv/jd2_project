package by.academy.it.chat;

import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.dao.PrivateChatDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Repository
@Transactional
public class PrivateChatDaoImpl implements PrivateChatDao {

    @Autowired
    @Qualifier("chattyDogSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public int save(PrivateChat chat) {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(chat);
        return (int) id;
    }

    @Override
    public PrivateChat findById(int chatId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(PrivateChat.class, chatId);
    }
}
