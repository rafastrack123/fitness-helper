package io.fitnesshelper.controller;

import io.fitnesshelper.dto.request.ConstraintRequest;
import io.fitnesshelper.dto.response.ConstraintResponse;
import io.fitnesshelper.entity.Constraint;
import io.fitnesshelper.service.ConstraintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/constraints")
public class ConstraintController {

    private final ConstraintService service;

    @PostMapping
    public ConstraintResponse create(@RequestBody ConstraintRequest request) {
        var constraint = from(request);
        var saved = service.create(constraint);
        return from(saved);
    }

    @PutMapping("/{id}")
    public ConstraintResponse update(@PathVariable Long id, @RequestBody ConstraintRequest request) {
        var oldConstraint = service.getById(id);
        var constraint = fromUpdate(request, oldConstraint);
        var saved = service.create(constraint);
        return from(saved);
    }

    private Constraint fromUpdate(ConstraintRequest request, Constraint constraint) {
        constraint.setName(request.getName());
        constraint.setName(request.getName());
        constraint.setName(request.getName());
        constraint.setNeedApproval(request.isNeedApproval());

        return constraint;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private ConstraintResponse from(Constraint request) {
        var response = new ConstraintResponse();

        response.setName(request.getName());
        response.setDescription(request.getDescription());
        response.setSessionDurationMinutes(request.getSessionDurationMinutes());
        response.setNeedApproval(request.isNeedApproval());

        return response;
    }

    private Constraint from(ConstraintRequest request) {
        var constraint = new Constraint();

        constraint.setName(request.getName());
        constraint.setName(request.getName());
        constraint.setName(request.getName());
        constraint.setNeedApproval(request.isNeedApproval());

        return constraint;
    }
}
