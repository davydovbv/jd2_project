package by.academy.it.converter.user;

import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.Friends;
import by.academy.it.user.pojo.RequestStatus;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AppUsersToFriendsToRemoveConverter {
    public Friends convert(AppUser owner, AppUser friend) {
        Friends friendsToRemove = new Friends();
        friendsToRemove.setOwner(owner);
        friendsToRemove.setFriend(friend);
        friendsToRemove.setStatus(Collections.singleton(RequestStatus.APPROVED));
        return friendsToRemove;
    }
}
