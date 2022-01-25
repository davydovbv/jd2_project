package by.academy.it.service;

import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.dto.chat.ChatWithUserDto;
public interface ChatService {
    int save(int currentUserId, int targetUserId);
    PrivateChat findById(int chatId);
    ChatWithUserDto findChatWithUseDtoById(int chatId, int currentUserId);
}
