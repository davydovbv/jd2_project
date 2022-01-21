package by.academy.it.converter.user;

import by.academy.it.dto.user.user.UserForSearchDto;
import by.academy.it.user.pojo.AppUser;
import org.springframework.stereotype.Component;

@Component
public class UserForSearchDtoConverter {
    public UserForSearchDto convert(AppUser appUser) {
        UserForSearchDto userForSearchDto = new UserForSearchDto();
        userForSearchDto.setFirstName(appUser.getFirstName());
        userForSearchDto.setLastName(appUser.getLastName());
        userForSearchDto.setCity(appUser.getCity());
        userForSearchDto.setStatus(userForSearchDto.getStatus());
        userForSearchDto.setId(appUser.getId());
        return userForSearchDto;
    }
}
