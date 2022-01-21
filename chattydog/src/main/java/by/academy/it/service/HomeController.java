package by.academy.it.service;

import by.academy.it.dto.user.user.UserInformationDto;
import by.academy.it.exceptions.ContentNotFoundException;
import by.academy.it.service.security.DbAuthenticationService;
import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.AppUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    DbAuthenticationService dbAuthenticationService;
    @Autowired
    UserService userService;

    @ExceptionHandler(ContentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleContentNotFoundException(ContentNotFoundException exception) {
        return exception.getMessage();
    }

    @GetMapping("/home")
    public ModelAndView getCurrentUserInformation(){
        ModelAndView modelAndView = new ModelAndView("home/home");
        AppUserCredentials user = dbAuthenticationService.getCurrentUser();
        UserInformationDto userInformation = userService.getUserInformation(user.getAppUserId());
        modelAndView.addObject("user", userInformation);
        modelAndView.addObject("showButtons", false);
        return modelAndView;
    }

    @GetMapping("/home/{id}")
    public ModelAndView getUserInformation(@PathVariable("id") int targetAppUserId){
        AppUserCredentials currentUser = dbAuthenticationService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView("home/home");
        UserInformationDto userInformation = userService.getUserInformation(targetAppUserId);
        modelAndView.addObject("user", userInformation);
        if (targetAppUserId == currentUser.getId()) {
            modelAndView.addObject("showButtons", false);
        } else {
            modelAndView.addObject("showButtons", true);
        }
        return modelAndView;
    }
}
