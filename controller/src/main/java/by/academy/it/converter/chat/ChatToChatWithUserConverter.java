package by.academy.it.converter.chat;

import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.chat.pojo.PrivateMessage;
import by.academy.it.dto.chat.ChatWithUserDto;
import by.academy.it.dto.chat.PrivateMessageDto;
import by.academy.it.user.pojo.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ChatToChatWithUserConverter {

    @Autowired
    PrivateMessageDtoConverter privateMessageDtoConverter;

    public ChatWithUserDto convert(PrivateChat privateChat, int currentUserId) {
        ChatWithUserDto chatWithUserDto = new ChatWithUserDto();
        chatWithUserDto.setChatId(privateChat.getId());
        Optional<AppUser> participant = privateChat.getParticipants().stream().filter(appUser -> appUser.getId() != currentUserId)
                .findFirst();
        participant.ifPresent(user ->chatWithUserDto.setChatterFullName(user.getFirstName() + " " + user.getLastName()));
        participant.ifPresent(user -> chatWithUserDto.setChatterId(user.getId()));
        List<PrivateMessage> chatMessages = privateChat.getMessages();
        if (chatMessages != null) {
            List<PrivateMessageDto> messages = chatMessages.stream()
                    .map(privateMessage -> privateMessageDtoConverter.convert(privateMessage))
                    .collect(Collectors.toList());
            chatWithUserDto.setMessages(messages);
        }
        return chatWithUserDto;
    }
}
