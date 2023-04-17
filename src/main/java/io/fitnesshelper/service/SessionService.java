package io.fitnesshelper.service;

import io.fitnesshelper.entity.Session;
import io.fitnesshelper.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository repository;

    public Session save(Session session) {
        return repository.save(session);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
