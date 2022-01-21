package by.academy.it.dao;

import by.academy.it.user.pojo.AppUserContactDetails;

public interface AppUserContactDetailsDao {
    void save(AppUserContactDetails appUserContactDetails);

    AppUserContactDetails findByUserId(int uppUserId);
}
