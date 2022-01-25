package by.academy.it.dto.chat;

import lombok.Data;

@Data
public class ChatFoChatListDto {
    private int chatId;
    private int senderId;
    private int chatterId;
    private String chatterFullName;
    private String senderName;
    private String created;
    private String LastMessageContent;
}
