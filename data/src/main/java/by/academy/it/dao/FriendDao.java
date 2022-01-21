package by.academy.it.dao;
import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.Friends;

import java.util.List;

public interface FriendDao {
    void addFriendRequest(Friends request);

    List<Friends> findAllFriendRequests(AppUser receiver);

    void acceptRequest(AppUser sender, AppUser receiver);

    void save(Friends request);

    List<Friends> findAllFriends(AppUser owner);

    Friends findUserFriend(AppUser owner, AppUser friend);

    void removeFromFriends(Friends friendsToRemove);
}
