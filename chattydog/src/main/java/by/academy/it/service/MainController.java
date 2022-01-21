package by.academy.it.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "redirect:/topics";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login/login";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {

        return new ModelAndView("403");
    }

}
