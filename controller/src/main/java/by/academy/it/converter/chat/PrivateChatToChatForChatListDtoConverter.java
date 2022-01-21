package by.academy.it.converter.chat;

import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.chat.pojo.PrivateMessage;
import by.academy.it.dto.chat.ChatFoChatListDto;
import by.academy.it.user.pojo.AppUser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PrivateChatToChatForChatListDtoConverter {
    public ChatFoChatListDto convert(PrivateChat chat, int currentUserId) {
        ChatFoChatListDto chatForChatListDto = new ChatFoChatListDto();
        chatForChatListDto.setChatId(chat.getId());
        Optional<AppUser> participant = chat.getParticipants().stream().filter(appUser -> appUser.getId() != currentUserId)
                        .findFirst();
        participant.ifPresent(user -> chatForChatListDto.setChatterId(user.getId()));
        participant.ifPresent(user -> chatForChatListDto.setChatterFullName(user.getFirstName() + " " + user.getLastName()));
        List<PrivateMessage> messages = chat.getMessages();
        if(!messages.isEmpty()) {
            PrivateMessage message = chat.getMessages().get(messages.size()-1);
            chatForChatListDto.setSenderId(message.getSender().getId());
            chatForChatListDto.setSenderName(message.getSender().getFirstName());
            chatForChatListDto.setCreated(message.getCreated());
            chatForChatListDto.setLastMessageContent(message.getContent());
        }
        return chatForChatListDto;
    }
}
