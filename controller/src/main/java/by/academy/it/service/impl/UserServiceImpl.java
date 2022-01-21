package by.academy.it.service.impl;

import by.academy.it.exceptions.ContentNotFoundException;
import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.converter.chat.ChatToChatWithUserConverter;
import by.academy.it.converter.chat.PrivateChatToChatForChatListDtoConverter;
import by.academy.it.converter.topic.TopicForSearchDtoConverter;
import by.academy.it.converter.user.UserForSearchDtoConverter;
import by.academy.it.converter.user.UserInformationDtoConverter;
import by.academy.it.converter.user.UserRegistrationDtoToAppUserConverter;
import by.academy.it.converter.user.UserRegistrationDtoToAppUserCredentialsConverter;
import by.academy.it.converter.user.UserRegistrationDtoToUserContactDetailsConverter;
import by.academy.it.dao.AppUserCredentialsDao;
import by.academy.it.dao.AppUserDao;
import by.academy.it.dao.FriendDao;
import by.academy.it.dto.chat.ChatFoChatListDto;
import by.academy.it.dto.chat.ChatWithUserDto;
import by.academy.it.dto.topic.TopicForSearchDto;
import by.academy.it.dto.user.user.UserForSearchDto;
import by.academy.it.dto.user.user.UserInformationDto;
import by.academy.it.dto.user.user.UserRegistrationDto;
import by.academy.it.service.ChatService;
import by.academy.it.service.TopicService;
import by.academy.it.service.UserService;
import by.academy.it.topic.pojo.Topic;
import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.AppUserContactDetails;
import by.academy.it.user.pojo.AppUserCredentials;
import by.academy.it.user.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private AppUserCredentialsDao appUserCredentialsDao;

    @Autowired
    TopicService topicService;

    @Autowired
    private PrivateChatToChatForChatListDtoConverter privateChatToChatForChatListDtoConverter;

    @Autowired
    private UserRegistrationDtoToUserContactDetailsConverter userRegistrationDtoToUserContactDetailsConverter;

    @Autowired
    private UserInformationDtoConverter userInformationDtoConverter;

    @Autowired
    private UserRegistrationDtoToAppUserConverter userRegistrationDtoToAppUserConverter;

    @Autowired
    private UserRegistrationDtoToAppUserCredentialsConverter userRegistrationDtoToAppUserCredentialsConverter;

    @Autowired
    private UserForSearchDtoConverter userForSearchDtoConverter;

    @Autowired
    private ChatToChatWithUserConverter chatToChatWithUserConverter;

    @Autowired
    private TopicForSearchDtoConverter topicForSearchDtoConverter;

    @Autowired
    private FriendDao friendDao;

    @Autowired
    ChatService chatService;


    @Override
    @Transactional
    public void addNewUser(UserRegistrationDto userRegistrationDto) {
        AppUser appUser = userRegistrationDtoToAppUserConverter.convert(userRegistrationDto);
        AppUserContactDetails appUserContactDetails = userRegistrationDtoToUserContactDetailsConverter.convert(userRegistrationDto);
        appUser.setAppUserContactDetails(appUserContactDetails);
        int appUserId = appUserDao.saveUser(appUser);
        AppUserCredentials appUserCredentials = userRegistrationDtoToAppUserCredentialsConverter.convert(userRegistrationDto);
        appUserCredentials.setAppUserId(appUserId);
        appUserCredentials.setActive(true);
        appUserCredentials.setRoles(Collections.singleton(UserRole.USER));
        appUserCredentialsDao.save(appUserCredentials);
    }

    @Override
    public AppUserCredentials findUserByLogin(String login) {
        return appUserCredentialsDao.findByUsername(login);
    }

    @Override
    @Transactional
    public List<UserForSearchDto> getAllUsersForSearch(int currentAppUserId) {
        AppUser currentUser = findUserById(currentAppUserId);
        List<Integer> allFriendsId = friendDao.findAllFriends(currentUser).stream()
                .map(friend -> friend.getFriend().getId())
                .collect(Collectors.toList());
        return appUserCredentialsDao.getAllActiveUsersId().stream()
                .filter(id -> !allFriendsId.contains(id))
                .map(id -> appUserDao.findById(id))
                .map(user -> userForSearchDtoConverter.convert(user))
                .filter(user -> currentUser.getId() != user.getId())
                .collect(Collectors.toList());
    }

    @Override
   @Transactional
    public UserInformationDto getUserInformation(int appUserId) {
        AppUser appUser = findUserById(appUserId);
        return userInformationDtoConverter.convert(appUser);
    }

    @Override
    @Transactional
    public List<ChatFoChatListDto> getAllUserChats(int currentUserId) {
        AppUser currentUser = findUserById(currentUserId);
        return currentUser.getUserPrivateChats().stream()
                .map(chat -> privateChatToChatForChatListDtoConverter.convert(chat, currentUserId))
                                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public PrivateChat getPrivateChatWithUser(int currentUserId, int targetUserId) {
        AppUser currentUser = findUserById(currentUserId);
        AppUser targetUser = findUserById(targetUserId);
        List<PrivateChat> privateChats = currentUser.getUserPrivateChats().stream()
                .filter(chat -> chat.getParticipants().contains(targetUser))
                .collect(Collectors.toList());
        PrivateChat privateChat = null;
        if (!privateChats.isEmpty()) {
            privateChat = privateChats.get(0);
        }
        return privateChat;
    }

    @Override
    @Transactional
    public AppUser findUserById(int appUserId) {
        AppUser appUser = appUserDao.findById(appUserId);
        if (appUser == null) {
            throw new ContentNotFoundException("User with id: " + appUserId + "doesn't exist");
        }
        return appUser;
    }

    @Override
    @Transactional
    public void addTopicToFavorite(int topicId, int userId) {
        Topic topic = topicService.getTopicById(topicId);
        AppUser appUser = findUserById(userId);
        List<Topic> userTopics = appUser.getUserTopics();
        if (userTopics.isEmpty()) {
            userTopics = new ArrayList<>();
        }
        userTopics.add(topic);
        appUser.setUserTopics(userTopics);
        appUserDao.updateUser(appUser);
    }

    @Override
    @Transactional
    public void removeTopicFromFavorite(int topicId, int userId) {
        Topic topic = topicService.getTopicById(topicId);
        AppUser appUser = findUserById(userId);
        List<Topic> userTopics = appUser.getUserTopics();
        userTopics.remove(topic);
        appUser.setUserTopics(userTopics);
        appUserDao.updateUser(appUser);
    }

    @Override
    @Transactional
    public List<Topic> getUsersFavoriteTopics(int userId) {
        AppUser appUser = findUserById(userId);
        return appUser.getUserTopics().stream()
                .filter(topic -> !topic.isDeleted())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Map<String,List<TopicForSearchDto>> getUserFavoriteTopicsDto(int userId) {
        AppUser appUser = findUserById(userId);
        List<Topic> userTopics = appUser.getUserTopics();
        List<TopicForSearchDto> personalTopics = getUsersFavoriteTopics(userId).stream()
                .filter(topic -> topic.getAppUser().getId() == userId)
                .map(topic -> topicForSearchDtoConverter.convert(topic))
                .collect(Collectors.toList());
        List<TopicForSearchDto> favoriteTopics = userTopics.stream()
                .filter(topic -> topic.getAppUser().getId() != userId)
                .map(topic -> topicForSearchDtoConverter.convert(topic))
                .collect(Collectors.toList());
        Map<String,List<TopicForSearchDto>> topics = new HashMap<>();
        topics.put("favorite", favoriteTopics);
        topics.put("personal", personalTopics);
        return topics;
    }
}
