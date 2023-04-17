package io.fitnesshelper.dto.request;

import io.fitnesshelper.entity.enums.SessionType;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SessionRequest {

    private Long customerId;
    private Long professionalId;
    private LocalDateTime date;
    private SessionType type;

}
