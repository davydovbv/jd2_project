package by.academy.it.service;

import by.academy.it.dto.user.user.UserForSearchDto;
import by.academy.it.exceptions.ContentNotFoundException;
import by.academy.it.service.security.DbAuthenticationService;
import by.academy.it.user.pojo.AppUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FriendsController {
    @Autowired
    UserService userService;
    @Autowired
    FriendsService friendsService;
    @Autowired
    DbAuthenticationService dbAuthenticationService;

    @ExceptionHandler(ContentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleContentNotFoundException(ContentNotFoundException exception) {
        return exception.getMessage();
    }

    @GetMapping("/friends/find")
    public ModelAndView getAllUsers(){
        AppUserCredentials currentUser = dbAuthenticationService.getCurrentUser();
        List<UserForSearchDto> users = userService.getAllUsersForFriendSearch(currentUser.getAppUserId());
        ModelAndView modelAndView = new ModelAndView("friends/find_friends");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/friends/{id}")
    public String addFriendRequest(HttpServletRequest httpServletRequest, @PathVariable("id") int id) {
        AppUserCredentials owner = dbAuthenticationService.getCurrentUser();
        friendsService.addFriendRequest(owner.getId(), id);
        String referer = httpServletRequest.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping("/friends/requests")
    public ModelAndView getAllFriendsRequests() {
        AppUserCredentials user = dbAuthenticationService.getCurrentUser();
        List<UserForSearchDto> allFriendsRequests = friendsService.getAllFriendsRequests(user.getAppUserId());
        ModelAndView modelAndView = new ModelAndView("friends/friendship_request");
        modelAndView.addObject("requests", allFriendsRequests);
        return modelAndView;
    }

    @GetMapping("/friends/requests/{id}")
    public String acceptRequest(HttpServletRequest httpServletRequest, @PathVariable("id") int senderId) {
        AppUserCredentials receiver = dbAuthenticationService.getCurrentUser();
        friendsService.acceptRequest(receiver.getAppUserId(), senderId);
        String referer = httpServletRequest.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping("/friends")
    public ModelAndView getAllFriends() {
        AppUserCredentials owner = dbAuthenticationService.getCurrentUser();
        List<UserForSearchDto> allFriends = friendsService.getAllFriendsDto(owner.getAppUserId());
        ModelAndView modelAndView = new ModelAndView("friends/friends");
        modelAndView.addObject("friends",allFriends);
        return modelAndView;
    }

    @GetMapping("/friends/remove/{id}")
    public String removeFromFriends(HttpServletRequest httpServletRequest, @PathVariable("id") int friendId) {
        AppUserCredentials owner = dbAuthenticationService.getCurrentUser();
        friendsService.removeFromFriends(owner.getAppUserId(), friendId);
        String referer = httpServletRequest.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping("/friends/decline/{id}")
    public String declineFriendRequest(HttpServletRequest httpServletRequest, @PathVariable("id") int requestOwnerId) {
        AppUserCredentials receiver = dbAuthenticationService.getCurrentUser();
        friendsService.declineRequest(receiver.getAppUserId(), requestOwnerId);
        String referer = httpServletRequest.getHeader("Referer");
        return "redirect:" + referer;
    }


}
