package by.academy.it.dao;

import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.user.pojo.AppUser;

import java.util.List;

public interface PrivateChatDao {
    int save(PrivateChat chat);
    PrivateChat findById(int chatId);
}
