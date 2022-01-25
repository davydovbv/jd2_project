package by.academy.it.service;

import by.academy.it.dto.user.user.UserForSearchDto;

import java.util.List;

public interface AdminService {
    List<UserForSearchDto> getAllActiveUsers(int currentAppUserId);
    List<UserForSearchDto> getAllBlockedUsers(int currentAppUserId);
    void blockUser(int targetUserId);
    void activateUSer(int targetUserId);
}
