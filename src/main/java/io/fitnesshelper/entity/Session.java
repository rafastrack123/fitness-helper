package io.fitnesshelper.entity;

import static io.fitnesshelper.entity.enums.SessionType.RECURRENT;
import static jakarta.persistence.GenerationType.AUTO;

import io.fitnesshelper.entity.enums.SessionType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;

@Entity
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private LocalTime recurrentTime;
    private DayOfWeek dayOfWeek;
    private LocalDateTime occurrenceDate;
    private SessionType type;

    @ManyToOne
    private User professional;

    @ManyToOne
    private User customer;

    public DayOfWeek getDayOfWeek() {
        if (isRecurrent()) {
            return dayOfWeek;
        } else {
            return occurrenceDate.getDayOfWeek();
        }
    }

    public LocalTime getSessionTime() {
        if (isRecurrent()) {
            return getRecurrentTime();
        } else {
            return getOccurrenceDate().toLocalTime();
        }
    }

    private boolean isRecurrent() {
        return getType() == RECURRENT;
    }
}
