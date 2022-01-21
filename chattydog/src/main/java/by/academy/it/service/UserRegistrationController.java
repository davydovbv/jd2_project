package by.academy.it.service;

import by.academy.it.dto.user.user.UserRegistrationDto;
import by.academy.it.exceptions.ContentNotFoundException;
import by.academy.it.user.pojo.AppUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public ModelAndView registerNewUserView() {
        return new ModelAndView("registration/registration");
    }

    @ExceptionHandler(ContentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleContentNotFoundException(ContentNotFoundException exception) {
        return exception.getMessage();
    }

    @PostMapping("/registration")
    public String registerUser(UserRegistrationDto userRegistrationDto, Map<String, Object> model) {
        AppUserCredentials userFromDb = userService.findUserByLogin(userRegistrationDto.getUsername());
        if (userFromDb != null) {
            model.put("message", "User already exist!");
            return "registration/registration";
        }
        userService.addNewUser(userRegistrationDto);
        return "redirect:/login";
    }
}
