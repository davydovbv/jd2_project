package by.academy.it.service.impl;

import by.academy.it.converter.chat.ChatToChatWithUserConverter;
import by.academy.it.dto.chat.ChatWithUserDto;
import by.academy.it.exceptions.ContentNotFoundException;
import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.dao.PrivateChatDao;
import by.academy.it.service.ChatService;
import by.academy.it.service.UserService;
import by.academy.it.user.pojo.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private PrivateChatDao privateChatDao;

    @Autowired
    UserService userService;

    @Autowired
    ChatToChatWithUserConverter chatToChatWithUserConverter;

    @Override
    @Transactional
    public int save(int currentUserId, int targetUserId) {
        AppUser targetUser = userService.findUserById(targetUserId);
        if(targetUser == null) {
            throw new IllegalArgumentException("User with id:" + targetUserId + " doesn't exist");
        }
        AppUser currentUser = userService.findUserById(currentUserId);
        PrivateChat privateChat = new PrivateChat();
        privateChat.setParticipants(List.of(currentUser, targetUser));
        return privateChatDao.save(privateChat);
    }

    @Override
    @Transactional
    public PrivateChat findById(int chatId) {
        PrivateChat privateChat = privateChatDao.findById(chatId);
        if(privateChat == null) {
            throw new ContentNotFoundException("Chat with:" + chatId + " doesn't exist");
        }
        return privateChat;
    }

    @Override
    @Transactional
    public ChatWithUserDto findChatWithUseDtoById(int chatId, int currentUserId) {
        PrivateChat chat = findById(chatId);
        return chatToChatWithUserConverter.convert(chat, currentUserId);
    }

}
