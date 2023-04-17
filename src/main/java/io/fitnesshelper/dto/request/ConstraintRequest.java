package io.fitnesshelper.dto.request;

import lombok.Data;

@Data
public class ConstraintRequest {

    private String name;
    private String description;
    private Long sessionDurationMinutes;
    private boolean needApproval;

}
