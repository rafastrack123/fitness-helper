package io.fitnesshelper.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ProfessionalCalendarResponse {

    private List<DaySlots> daySlots;

}
