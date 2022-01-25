package by.academy.it.service.impl;

import by.academy.it.converter.user.UserForSearchDtoConverter;
import by.academy.it.dao.AppUserCredentialsDao;
import by.academy.it.dao.AppUserDao;
import by.academy.it.dto.user.user.UserForSearchDto;
import by.academy.it.exceptions.ContentNotFoundException;
import by.academy.it.service.AdminService;
import by.academy.it.service.UserService;
import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.AppUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    UserService userService;

    @Autowired
    private AppUserCredentialsDao appUserCredentialsDao;

    @Autowired
    private UserForSearchDtoConverter userForSearchDtoConverter;

    @Override
    public List<UserForSearchDto> getAllActiveUsers(int currentAppUserId){
        AppUser currentUser = userService.findUserById(currentAppUserId);
        return appUserCredentialsDao.getAllActiveUsersId().stream()
                .map(id -> appUserDao.findById(id))
                .map(user -> userForSearchDtoConverter.convert(user))
                .filter(user -> currentUser.getId() != user.getId())
                .collect(Collectors.toList());
    }

    @Override
    public List<UserForSearchDto> getAllBlockedUsers(int currentAppUserId){
        AppUser currentUser = userService.findUserById(currentAppUserId);
        return appUserCredentialsDao.getAllBlockedUsersId().stream()
                .map(id -> appUserDao.findById(id))
                .map(user -> userForSearchDtoConverter.convert(user))
                .filter(user -> currentUser.getId() != user.getId())
                .collect(Collectors.toList());
    }

    public void blockUser(int targetUserId) {
        AppUserCredentials targetUserCredentials = appUserCredentialsDao.getByAppUserId(targetUserId);
        if (targetUserCredentials == null) {
            throw new ContentNotFoundException("User with id " + targetUserId + " was not found");
        }
        targetUserCredentials.setActive(false);
        appUserCredentialsDao.update(targetUserCredentials);
    }

    @Override
    public void activateUSer(int targetUserId) {
        AppUserCredentials targetUserCredentials = appUserCredentialsDao.getByAppUserId(targetUserId);
        if (targetUserCredentials == null) {
            throw new ContentNotFoundException("User with id " + targetUserId + " was not found");
        }
        targetUserCredentials.setActive(true);
        appUserCredentialsDao.update(targetUserCredentials);
    }
}
