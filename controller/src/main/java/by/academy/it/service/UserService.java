package by.academy.it.service;

import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.dto.chat.ChatFoChatListDto;
import by.academy.it.dto.chat.ChatWithUserDto;
import by.academy.it.dto.topic.TopicForSearchDto;
import by.academy.it.dto.topic.TopicPageDto;
import by.academy.it.dto.user.user.UserForSearchDto;
import by.academy.it.dto.user.user.UserInformationDto;
import by.academy.it.dto.user.user.UserRegistrationDto;
import by.academy.it.topic.pojo.Topic;
import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.AppUserCredentials;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserService {

    void addNewUser(UserRegistrationDto userRegistrationDto);

    AppUserCredentials findUserByLogin(String login);

    List<UserForSearchDto> getAllUsersForSearch(int currentUserId);

    UserInformationDto getUserInformation(int appUserId);

    List<ChatFoChatListDto> getAllUserChats(int  currentUserId);

    PrivateChat getPrivateChatWithUser(int currentUserId, int targetUserId);

    AppUser findUserById(int appUserId);

    void addTopicToFavorite(int topicId, int userId);

    Map<String,List<TopicForSearchDto>> getUserFavoriteTopicsDto(int userId);

    List<Topic> getUsersFavoriteTopics(int userId);

    void removeTopicFromFavorite(int topicId, int userId);

}
