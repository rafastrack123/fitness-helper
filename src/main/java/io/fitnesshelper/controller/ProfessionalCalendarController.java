package io.fitnesshelper.controller;

import io.fitnesshelper.dto.response.ProfessionalCalendarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/professional-calendar")
public class ProfessionalCalendarController {

    @GetMapping("/{id}")
    public ProfessionalCalendarResponse get(@PathVariable Long id) {
        return null;
    }
}
