package by.academy.it.dto.chat;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PrivateMessageCreateDto {
    private int chatId;
    private int senderId;
    private LocalDateTime created;
    private String content;

}
