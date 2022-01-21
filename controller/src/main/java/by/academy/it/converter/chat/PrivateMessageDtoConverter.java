package by.academy.it.converter.chat;

import by.academy.it.chat.pojo.PrivateMessage;
import by.academy.it.dto.chat.PrivateMessageDto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PrivateMessageDtoConverter {
    public PrivateMessageDto convert(PrivateMessage privateMessage) {
        PrivateMessageDto privateMessageDto = new PrivateMessageDto();
        privateMessageDto.setMessageId(privateMessage.getId());
        privateMessageDto.setChatId(privateMessage.getChat().getId());
        privateMessageDto.setSenderId(privateMessage.getSender().getId());
        privateMessageDto.setSenderFullName(privateMessage.getSender().getFirstName() + " " + privateMessage.getSender().getLastName());
        privateMessageDto.setContent(privateMessage.getContent());
        privateMessageDto.setCreated(privateMessage.getCreated());
        return privateMessageDto;
    }
}
