package by.academy.it.converter.user;

import by.academy.it.dto.user.user.UserRegistrationDto;
import by.academy.it.user.pojo.AppUser;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoToAppUserConverter {
    public AppUser convert(UserRegistrationDto userRegistrationDto) {
        AppUser appUser = new AppUser();
        appUser.setFirstName(userRegistrationDto.getFirstName());
        appUser.setLastName(userRegistrationDto.getLastName());
        appUser.setCountry(userRegistrationDto.getCountry());
        appUser.setCity(userRegistrationDto.getCity());
        appUser.setStatus(userRegistrationDto.getStatus());
        appUser.setAboutInfo(userRegistrationDto.getAboutInfo());
        return appUser;
    }
}
