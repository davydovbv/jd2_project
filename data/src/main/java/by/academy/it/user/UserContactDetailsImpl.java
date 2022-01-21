package by.academy.it.user;

import by.academy.it.dao.AppUserContactDetailsDao;
import by.academy.it.user.pojo.AppUserContactDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserContactDetailsImpl implements AppUserContactDetailsDao {

    @Autowired
    @Qualifier("chattyDogSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void save(AppUserContactDetails appUserContactDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.save(appUserContactDetails);
    }

    @Override
    public AppUserContactDetails findByUserId(int appUserId) {
        Session session = sessionFactory.getCurrentSession();
        List<AppUserContactDetails> list = session.createQuery(" from UserContactDetails where appUserId = :appUser", AppUserContactDetails.class)
                .setParameter("appUser", appUserId)
                .list();
        AppUserContactDetails appUserContactDetails = null;
        if (list.size() > 0) {
            appUserContactDetails = list.get(0);
        }
        return appUserContactDetails;
    }
}
