package by.academy.it.service;

import by.academy.it.dto.topic.TopicCreateDto;
import by.academy.it.dto.topic.TopicForSearchDto;
import by.academy.it.dto.topic.TopicMessageCreateDto;
import by.academy.it.dto.topic.TopicPageDto;
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
import java.util.Map;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;

    @Autowired
    UserService userService;

    @Autowired
    TopicMessageService topicMessageService;

    @Autowired
    private DbAuthenticationService dbAuthenticationService;

    @ExceptionHandler(ContentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleContentNotFoundException(ContentNotFoundException exception) {
        return exception.getMessage();
    }

    @GetMapping("/topics")
    public ModelAndView findTopics() {
        List<TopicForSearchDto> topics = topicService.findAllTopics();
        ModelAndView modelAndView = new ModelAndView("/topic/topics_search");
        modelAndView.addObject("topics",topics);
        return modelAndView;
    }

    @GetMapping("/topics/create")
    public ModelAndView getCreateTopicPage() {
        return new ModelAndView("/topic/create_topic");
    }


    @PostMapping("/topics/create")
    public String createTopic(TopicCreateDto topicCreateDto) {
        Integer creatorId = dbAuthenticationService.getCurrentUser().getId();
        int topicId = topicService.createTopic(topicCreateDto, creatorId);
        userService.addTopicToFavorite(topicId, creatorId);
        return "redirect:/topics/favorite";
    }

    @GetMapping("/topics/{id}")
    public ModelAndView getTopic(@PathVariable("id") int topicId) {
        Integer currentUserId = dbAuthenticationService.getCurrentUser().getId();
        TopicPageDto topic = topicService.getTopicDtoByTopicId(topicId);
        boolean addButton = topicService.showAddToFavoriteButton(topicId, currentUserId);
        boolean removeButton = topicService.showRemoveFromFavoriteButton(topicId, currentUserId);
        ModelAndView modelAndView = new ModelAndView("/topic/topic_page");
        modelAndView.addObject("topic",  topic);
        modelAndView.addObject("add",addButton);
        modelAndView.addObject("remove",removeButton);
        return modelAndView;
    }

    @PostMapping("/topics/{id}/message")
    public String addMessageToTopic(TopicMessageCreateDto topicMessageCreateDto, @PathVariable("id") int topicId) {
        AppUserCredentials userCredentials = dbAuthenticationService.getCurrentUser();
        topicMessageCreateDto.setTopicId(topicId);
        topicMessageCreateDto.setAuthorId(userCredentials.getAppUserId());
        topicMessageService.save(topicMessageCreateDto);
        return "redirect:/topics/" + topicId;
    }

    @GetMapping("/topics/{id}/add")
    public String addTopicToFavorite(@PathVariable("id") int topicId) {
        AppUserCredentials current = dbAuthenticationService.getCurrentUser();
        userService.addTopicToFavorite(topicId, current.getAppUserId());
        return "redirect:/topics/";
    }

    @GetMapping("/topics/favorite")
    public ModelAndView getFavoriteTopics() {
        AppUserCredentials user = dbAuthenticationService.getCurrentUser();
        Map<String, List<TopicForSearchDto>> userFavoriteTopics = userService.getUserFavoriteTopicsDto(user.getAppUserId());
        ModelAndView modelAndView = new ModelAndView("/topic/favorite_topics");
        modelAndView.addObject("personal", userFavoriteTopics.get("personal"));
        modelAndView.addObject("personalEmpty", userFavoriteTopics.get("personal").isEmpty());
        modelAndView.addObject("favorite", userFavoriteTopics.get("favorite"));
        modelAndView.addObject("favoriteEmpty", userFavoriteTopics.get("favorite").isEmpty());
        return modelAndView;
    }

    @GetMapping("/topics/{id}/remove")
    public String removeTopicFromFavorite(@PathVariable("id") int topicId) {
        AppUserCredentials current = dbAuthenticationService.getCurrentUser();
        userService.removeTopicFromFavorite(topicId, current.getAppUserId());
        return "redirect:/topics/favorite";
    }

    @GetMapping("/topics/{id}/delete")
    public String deleteTopic(@PathVariable("id") int topicId) {
        AppUserCredentials currentUser = dbAuthenticationService.getCurrentUser();
        topicService.deleteTopic(topicId, currentUser.getAppUserId());
        return "redirect:/topics/favorite";
    }
}
