package by.academy.it.dto.chat;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatFoChatListDto {
    private int chatId;
    private int senderId;
    private int chatterId;
    private String chatterFullName;
    private String senderName;
    private LocalDateTime created;
    private String LastMessageContent;
}
