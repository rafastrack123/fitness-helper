package io.fitnesshelper.controller;

import io.fitnesshelper.service.RelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/relations")
public class RelationController {

    private final RelationService service;

    @PostMapping("/professional/{professionalId}/customer/{customerId}")
    public void create(@PathVariable Long professionalId, @PathVariable Long customerId) {
        service.create(professionalId, customerId);
    }
}
