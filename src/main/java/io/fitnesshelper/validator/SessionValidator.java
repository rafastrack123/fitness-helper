package io.fitnesshelper.validator;

import static io.fitnesshelper.entity.enums.SessionType.SINGLE;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import io.fitnesshelper.entity.Session;
import io.fitnesshelper.service.RelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class SessionValidator {

    private final RelationService relationService;

    public void validate(Session session) {
        if (relationDoesNotExists(session)) {
            throw new ResponseStatusException(FORBIDDEN, "Cannot create session without relation from customer and professional");
        }

        if (isInPast(session)) {
            throw new ResponseStatusException(CONFLICT, "Date cannot be in past");
        }

        if (hasDateConflict(session)) {
            throw new ResponseStatusException(CONFLICT, "");
        }
    }

    private boolean hasDateConflict(Session session) {
        return false; // TODO
    }

    private boolean relationDoesNotExists(Session session) {
        return !relationService.existsRelation(session.getCustomer(), session.getProfessional());
    }


    private boolean isInPast(Session session) {
        return session.getType() == SINGLE &&
                session.getOccurrenceDate().isBefore(now());
    }
}
