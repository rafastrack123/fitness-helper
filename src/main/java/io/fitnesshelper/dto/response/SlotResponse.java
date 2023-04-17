package io.fitnesshelper.dto.response;

import java.time.LocalTime;
import lombok.Data;

@Data
public class SlotResponse {

    private boolean isOpenSlot;
    private LocalTime time;
}
