package io.fitnesshelper.dto.response;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class DaySlots {

    private LocalDate date;
    private List<SlotResponse> slots;
}
