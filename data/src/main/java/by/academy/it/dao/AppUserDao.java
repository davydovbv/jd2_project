package by.academy.it.dao;

import by.academy.it.user.pojo.AppUser;

public interface AppUserDao {

    int saveUser(AppUser appUser);

    AppUser findById(int id);

    void updateUser(AppUser appUser);
}
