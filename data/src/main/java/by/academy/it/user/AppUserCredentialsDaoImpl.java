package by.academy.it.user;

import by.academy.it.dao.AppUserCredentialsDao;
import by.academy.it.user.pojo.AppUserCredentials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AppUserCredentialsDaoImpl implements AppUserCredentialsDao {
    @Autowired
    @Qualifier("chattyDogSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public AppUserCredentials findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<AppUserCredentials> list = session.createQuery("from AppUserCredentials where username = :username", AppUserCredentials.class)
                .setParameter("username", username)
                .list();
        AppUserCredentials appUserCredentials = null;
        if (list.size() > 0) {
            appUserCredentials = list.get(0);
        }
        return appUserCredentials;
    }

    @Override
    public void save(AppUserCredentials appUserCredentials) {
        Session session = sessionFactory.getCurrentSession();
        session.save(appUserCredentials);
    }

    @Override
    public List<Integer> getAllActiveUsersId() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c.appUserId from AppUserCredentials c where c.active = true", Integer.class).list();
    }
}
