package by.academy.it.dao;

import by.academy.it.user.pojo.AppUserCredentials;

import java.util.List;

public interface AppUserCredentialsDao {
    AppUserCredentials findByUsername(String username);
    void save(AppUserCredentials appUserCredentials);
    List<Integer> getAllActiveUsersId();
    List<Integer> getAllBlockedUsersId();
    AppUserCredentials getByAppUserId(int appUserId);
    void update(AppUserCredentials appUserCredentials);
}
