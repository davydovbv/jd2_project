package by.academy.it.dto.user.user;

import lombok.Data;

@Data
public class UserInformationDto {
    private int id;
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
    private boolean friend;
}
