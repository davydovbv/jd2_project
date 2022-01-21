package by.academy.it.service.impl;

import by.academy.it.converter.user.UserForSearchDtoConverter;
import by.academy.it.dao.FriendDao;
import by.academy.it.dto.user.user.UserForSearchDto;
import by.academy.it.service.FriendsService;
import by.academy.it.service.UserService;
import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.Friends;
import by.academy.it.user.pojo.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendsServiceImpl implements FriendsService {
    @Autowired
    FriendDao friendDao;

    @Autowired
    UserService userService;


    @Autowired
    UserForSearchDtoConverter userForSearchDtoConverter;


    @Override
    @Transactional
    public void addFriendRequest(int ownerId, int friendId) {
        AppUser owner = userService.findUserById(ownerId);
        AppUser friend = userService.findUserById(friendId);
        Friends request = new Friends();
        request.setFriend(friend);
        request.setOwner(owner);
        request.setStatus(Collections.singleton(RequestStatus.SENT));
        friendDao.addFriendRequest(request);
    }

    @Override
    @Transactional
    public List<UserForSearchDto> getAllFriendsRequests(int currentUserId) {
        AppUser currentUser = userService.findUserById(currentUserId);
        return friendDao.findAllFriendRequests(currentUser).stream()
                .filter(request -> request.getStatus().contains(RequestStatus.SENT))
                .map(request -> userForSearchDtoConverter.convert(request.getOwner()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void acceptRequest(int receiverId, int senderId) {
        AppUser receiver = userService.findUserById(receiverId);
        AppUser sender = userService.findUserById(senderId);
        friendDao.acceptRequest(sender, receiver);
        Friends friends = new Friends();
        friends.setOwner(receiver);
        friends.setFriend(sender);
        friends.setStatus(Collections.singleton(RequestStatus.APPROVED));
        friendDao.save(friends);
    }

    @Override
    @Transactional
    public void declineRequest(int receiverId, int requestOwnerId) {
        AppUser owner = userService.findUserById(requestOwnerId);
        AppUser receiver = userService.findUserById(receiverId);
        Friends incomingFriendRequest = friendDao.findUserFriend(owner, receiver);
        friendDao.removeFromFriends(incomingFriendRequest);
    }

    @Override
    @Transactional
    public List<UserForSearchDto> getAllFriends(int ownerId) {
        AppUser owner = userService.findUserById(ownerId);
        return friendDao.findAllFriends(owner).stream()
                .filter(friend -> friend.getStatus().contains(RequestStatus.APPROVED))
                .map(friend -> userForSearchDtoConverter.convert(friend.getFriend()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removeFromFriends(int ownerId, int friendId) {
        AppUser owner = userService.findUserById(ownerId);
        AppUser friend = userService.findUserById(friendId);
        Friends friendsToRemove = friendDao.findUserFriend(owner, friend);
        Friends reversFriendsToRemove = friendDao.findUserFriend(friend, owner);
        friendDao.removeFromFriends(friendsToRemove);
        friendDao.removeFromFriends(reversFriendsToRemove);
    }
}
