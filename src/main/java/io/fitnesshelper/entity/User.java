package io.fitnesshelper.entity;

import static jakarta.persistence.GenerationType.AUTO;

import io.fitnesshelper.entity.enums.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Profile profile;

}
