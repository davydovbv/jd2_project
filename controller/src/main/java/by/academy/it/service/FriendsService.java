package by.academy.it.service;

import by.academy.it.dto.user.user.UserForSearchDto;
import by.academy.it.user.pojo.AppUser;

import java.util.List;

public interface FriendsService {
    void addFriendRequest(int ownerId, int friendId);
    List<UserForSearchDto> getAllFriendsRequests(int currentUserId);
    void declineRequest(int receiverId, int senderId);
    void acceptRequest(int receiverId, int senderId);
    List<UserForSearchDto> getAllFriends(int ownerId);
    void removeFromFriends(int ownerId, int friendId);
}
