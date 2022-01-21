package by.academy.it.service;

import by.academy.it.dto.chat.PrivateMessageCreateDto;

public interface MessageService {
    int save(PrivateMessageCreateDto privateMessageCreateDto);
}
