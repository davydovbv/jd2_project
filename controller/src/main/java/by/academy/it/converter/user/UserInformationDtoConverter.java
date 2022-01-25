package by.academy.it.converter.user;

import by.academy.it.dto.user.user.UserInformationDto;
import by.academy.it.user.pojo.AppUser;
import org.springframework.stereotype.Component;

@Component
public class UserInformationDtoConverter {

    public UserInformationDto convert(AppUser appUser) {
        UserInformationDto userInformationDto = new UserInformationDto();
        userInformationDto.setFirstName(appUser.getFirstName());
        userInformationDto.setLastName(appUser.getLastName());
        userInformationDto.setCountry(appUser.getCountry());
        userInformationDto.setCity(appUser.getCity());
        userInformationDto.setStatus(appUser.getStatus());
        userInformationDto.setAboutInfo(appUser.getAboutInfo());
        userInformationDto.setSkype(appUser.getAppUserContactDetails().getSkype());
        userInformationDto.setInstagram(appUser.getAppUserContactDetails().getInstagram());
        userInformationDto.setPhone(appUser.getAppUserContactDetails().getPhoneNumber());
        userInformationDto.setEmail(appUser.getAppUserContactDetails().getEmail());
        userInformationDto.setId(appUser.getId());
        return userInformationDto;
    }
}
