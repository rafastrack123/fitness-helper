package io.fitnesshelper.entity;

import static jakarta.persistence.GenerationType.AUTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Constraint {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Long id;

    private String name;
    private String description;

    @OneToMany
    private List<ConstraintTimeRule> constraintTimeRules;

    private Long sessionDurationMinutes;

    private boolean needApproval;

}
