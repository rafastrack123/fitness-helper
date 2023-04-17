package io.fitnesshelper.dto.response;

import io.fitnesshelper.entity.enums.SessionType;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SessionResponse {

    private Long id;
    private Long customerId;
    private Long professionalId;
    private LocalDateTime date;
    private SessionType type;
}
