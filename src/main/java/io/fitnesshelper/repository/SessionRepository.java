package io.fitnesshelper.repository;

import io.fitnesshelper.entity.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Long> {
}
