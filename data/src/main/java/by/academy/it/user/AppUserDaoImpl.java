package by.academy.it.user;

import by.academy.it.dao.AppUserDao;
import by.academy.it.user.pojo.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Repository
@Transactional
public class AppUserDaoImpl implements AppUserDao {

    @Autowired
    @Qualifier("chattyDogSessionFactory")
    private SessionFactory sessionFactory;

    public int saveUser(AppUser appUser) {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(appUser);
        return (int)id;
    }

    @Override
    public AppUser findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(AppUser.class, id);
    }

    @Override
    public void updateUser(AppUser appUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(appUser);
    }
}
