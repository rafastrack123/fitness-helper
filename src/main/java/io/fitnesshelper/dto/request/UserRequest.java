package io.fitnesshelper.dto.request;

import io.fitnesshelper.entity.enums.Profile;
import lombok.Data;

@Data
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Profile profile;

}
