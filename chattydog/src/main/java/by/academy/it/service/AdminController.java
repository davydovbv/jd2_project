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

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private DbAuthenticationService dbAuthenticationService;

    @Autowired
    private AdminService adminService;

    @ExceptionHandler(ContentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleContentNotFoundException(ContentNotFoundException exception) {
        return exception.getMessage();
    }


    @GetMapping("/admin/users/active")
    public ModelAndView getActiveUsers() {
        AppUserCredentials currentUser = dbAuthenticationService.getCurrentUser();
        List<UserForSearchDto> users = adminService.getAllActiveUsers(currentUser.getAppUserId());
        ModelAndView modelAndView = new ModelAndView("admin/active-users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/admin/users/blocked")
    public ModelAndView getBlockedUsers() {
        AppUserCredentials currentUser = dbAuthenticationService.getCurrentUser();
        List<UserForSearchDto> users = adminService.getAllBlockedUsers(currentUser.getAppUserId());
        ModelAndView modelAndView = new ModelAndView("admin/blocked-users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/admin/users/block/{id}")
    public String blockUser(@PathVariable("id") int targetUserId) {
        adminService.blockUser(targetUserId);
        return "redirect:/admin/users/active";
    }

    @GetMapping("/admin/users/activate/{id}")
    public String activateUser(@PathVariable("id") int targetUserId) {
        adminService.activateUSer(targetUserId);
        return "redirect:/admin/users/active";
    }
}
