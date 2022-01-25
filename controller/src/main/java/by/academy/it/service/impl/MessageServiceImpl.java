package by.academy.it.service.impl;

import by.academy.it.chat.pojo.PrivateMessage;
import by.academy.it.dao.PrivateMessageDao;
import by.academy.it.dto.chat.PrivateMessageCreateDto;
import by.academy.it.service.ChatService;
import by.academy.it.service.MessageService;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @Autowired
    private PrivateMessageDao privateMessageDao;

    @Override
    public int save(PrivateMessageCreateDto privateMessageCreateDto) {
        PrivateMessage privateMessage = new PrivateMessage();
        privateMessage.setContent(privateMessageCreateDto.getContent());
        privateMessage.setSender(userService.findUserById(privateMessageCreateDto.getSenderId()));
        privateMessage.setChat(chatService.findById(privateMessageCreateDto.getChatId()));
        privateMessage.setCreated(LocalDateTime.now());
        return privateMessageDao.save(privateMessage);
    }
}
