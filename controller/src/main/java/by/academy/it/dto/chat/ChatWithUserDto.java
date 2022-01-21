package by.academy.it.dto.chat;
import lombok.Data;

import java.util.List;

@Data
public class ChatWithUserDto {
    private int chatId;
    private String chatterFullName;
    private int chatterId;
    private List<PrivateMessageDto> messages;

}
