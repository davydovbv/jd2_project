package by.academy.it.service;

import by.academy.it.chat.pojo.PrivateChat;
import by.academy.it.dto.chat.ChatFoChatListDto;
import by.academy.it.dto.chat.ChatWithUserDto;
import by.academy.it.dto.chat.PrivateMessageCreateDto;
import by.academy.it.exceptions.ContentNotFoundException;
import by.academy.it.service.security.DbAuthenticationService;
import by.academy.it.user.pojo.AppUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChatController {
    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private DbAuthenticationService dbAuthenticationService;

    @ExceptionHandler(ContentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleContentNotFoundException(ContentNotFoundException exception) {
        return exception.getMessage();
    }

    @GetMapping("/chats")
    public ModelAndView getAllUserChats() {
        AppUserCredentials currentUser = dbAuthenticationService.getCurrentUser();
        List<ChatFoChatListDto> allUserChats = userService.getAllUserChats(currentUser.getAppUserId());
        ModelAndView modelAndView = new ModelAndView("/chat/user_chats");
        modelAndView.addObject("chats", allUserChats);
        return modelAndView;
    }

    @GetMapping("/chats/{id}")
    public ModelAndView getChatById(@PathVariable("id") int chatId) {
        AppUserCredentials user = dbAuthenticationService.getCurrentUser();
        ChatWithUserDto chatWithUserDto = chatService.findChatWithUseDtoById(chatId, user.getAppUserId());
        List<ChatFoChatListDto> allUserChats = userService.getAllUserChats(user.getAppUserId());
        boolean haveMessages = chatWithUserDto.getMessages() != null;
        ModelAndView modelAndView = new ModelAndView("chat/user_chats");
        modelAndView.addObject("chats", allUserChats);
        modelAndView.addObject("chat", chatWithUserDto);
        modelAndView.addObject("haveMessages", haveMessages);
        modelAndView.addObject("showChat", true);
        return modelAndView;
    }

    @PostMapping("/chats/{id}/message")
    public String saveMessage(@PathVariable("id") int chatId, PrivateMessageCreateDto privateMessageCreateDto) {
        AppUserCredentials currentUser = dbAuthenticationService.getCurrentUser();
        privateMessageCreateDto.setChatId(chatId);
        privateMessageCreateDto.setSenderId(currentUser.getAppUserId());
        messageService.save(privateMessageCreateDto);
        return "redirect:/chats/" + chatId;
    }

    @GetMapping("/chats/user/{id}")
    public String createChatWithUser(@PathVariable("id") int targetUserId) {
        AppUserCredentials currentUser = dbAuthenticationService.getCurrentUser();
        PrivateChat privateChatWithUser = userService.getPrivateChatWithUser(currentUser.getId(), targetUserId);
        if(privateChatWithUser != null) {
            return "redirect:/chats/" + privateChatWithUser.getId();
        } else {
            int chatId = chatService.save(currentUser.getAppUserId(), targetUserId);
            return "redirect:/chats/" + chatId;
        }
    }


}
