package by.academy.it.dto.chat;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PrivateMessageDto {
    private int messageId;
    private int chatId;
    private int senderId;
    private String senderFullName;
    private String content;
    private LocalDateTime created;
}
