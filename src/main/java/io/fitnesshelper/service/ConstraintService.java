package io.fitnesshelper.service;

import io.fitnesshelper.entity.Constraint;
import io.fitnesshelper.repository.ConstraintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ConstraintService {

    private final ConstraintRepository repository;

    public Constraint create(Constraint constraint) {
        return repository.save(constraint);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Constraint getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Constraint not found " + id));
    }
}
