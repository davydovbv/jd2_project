package by.academy.it.converter.user;

import by.academy.it.dto.user.user.UserRegistrationDto;
import by.academy.it.user.pojo.AppUserCredentials;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoToAppUserCredentialsConverter {
    public AppUserCredentials convert(UserRegistrationDto userRegistrationDto) {
        AppUserCredentials appUser = new AppUserCredentials();
        appUser.setUsername(userRegistrationDto.getUsername());
        appUser.setPassword(userRegistrationDto.getPassword());
        return appUser;
    }
}
