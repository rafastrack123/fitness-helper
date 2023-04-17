package io.fitnesshelper.entity;

import static jakarta.persistence.GenerationType.AUTO;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class ConstraintTimeRule {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private LocalTime startTime;
    private LocalTime endTime;

    @ElementCollection
    private List<DayOfWeek> days;
}
