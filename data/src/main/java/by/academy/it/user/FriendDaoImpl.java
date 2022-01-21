package by.academy.it.user;

import by.academy.it.dao.FriendDao;
import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.Friends;
import by.academy.it.user.pojo.RequestStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
    @Autowired
    @Qualifier("chattyDogSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void addFriendRequest(Friends request) {
        Session session = sessionFactory.getCurrentSession();
        session.save(request);
    }

    @Override
    public List<Friends> findAllFriendRequests(AppUser receiver) {
        Session session = sessionFactory.getCurrentSession();
        Set<RequestStatus> status = new HashSet<>();
        status.add(RequestStatus.SENT);
        List<Friends> list = session.createQuery(" from Friends where friend = ?1", Friends.class)
                .setParameter(1, receiver)
                .list();
        return list;
    }

    @Override
    public void acceptRequest(AppUser sender, AppUser receiver) {
        Session session = sessionFactory.getCurrentSession();
        List<Friends> allRequests = session.createQuery("from Friends where owner = ?1 and friend = ?2", Friends.class)
                .setParameter(1, sender)
                .setParameter(2, receiver)
                .list();
        Friends request = null;
        if(!allRequests.isEmpty()) {
            request = allRequests.get(0);
        }
        request.setStatus(Collections.singleton(RequestStatus.APPROVED));
        session.update(request);
    }

    @Override
    public void save(Friends request) {
        Session session = sessionFactory.getCurrentSession();
        session.save(request);
    }

    @Override
    public List<Friends> findAllFriends(AppUser owner) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Friends where owner = ?1", Friends.class)
                .setParameter(1, owner)
                .list();
    }

    @Override
    public Friends findUserFriend(AppUser owner, AppUser friend) {
        Session session = sessionFactory.getCurrentSession();
        List<Friends> friends = session.createQuery("from Friends where owner = ?1 and friend = ?2", Friends.class)
                .setParameter(1, owner)
                .setParameter(2, friend)
                .list();
        Friends uploadedFriend = null;
        if(!friends.isEmpty()) {
            uploadedFriend =  friends.get(0);
        }
        return uploadedFriend;
    }

    @Override
    public void removeFromFriends(Friends friendsToRemove) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(friendsToRemove);
    }
}
