package io.fitnesshelper.dto.response;

import io.fitnesshelper.entity.enums.Profile;
import lombok.Data;

@Data
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private Profile profile;
}
