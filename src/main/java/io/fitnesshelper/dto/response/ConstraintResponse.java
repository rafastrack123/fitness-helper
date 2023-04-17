package io.fitnesshelper.dto.response;

import lombok.Data;

@Data
public class ConstraintResponse {

    private String name;
    private String description;
    private Long sessionDurationMinutes;
    private boolean needApproval;

}
