package by.academy.it.dto.user.user;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String status;
    private String aboutInfo;
    private String skype;
    private String instagram;
    private String phone;
    private String email;
}
