package by.academy.it.dao;

import by.academy.it.chat.pojo.PrivateChat;

public interface PrivateChatDao {
    int save(PrivateChat chat);
    PrivateChat findById(int chatId);
}
