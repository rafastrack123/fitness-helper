package io.fitnesshelper.dto.response;

import io.fitnesshelper.entity.User;
import lombok.Data;

@Data
public class LoginResponse {

    private final String token;
    private final User user;

}
