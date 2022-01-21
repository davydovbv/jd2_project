package by.academy.it.converter.user;

import by.academy.it.dto.user.user.UserRegistrationDto;
import by.academy.it.user.pojo.AppUserContactDetails;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoToUserContactDetailsConverter {
    public AppUserContactDetails convert(UserRegistrationDto userRegistrationDto) {
        AppUserContactDetails appUserContactDetails = new AppUserContactDetails();
        appUserContactDetails.setEmail(userRegistrationDto.getEmail());
        appUserContactDetails.setInstagram(userRegistrationDto.getInstagram());
        appUserContactDetails.setSkype(userRegistrationDto.getSkype());
        appUserContactDetails.setPhoneNumber(userRegistrationDto.getPhone());
        return appUserContactDetails;
    }
}
