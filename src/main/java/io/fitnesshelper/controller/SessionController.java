package io.fitnesshelper.controller;

import static io.fitnesshelper.entity.enums.SessionType.SINGLE;

import io.fitnesshelper.dto.request.SessionRequest;
import io.fitnesshelper.entity.Session;
import io.fitnesshelper.service.SessionService;
import io.fitnesshelper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/session")
public class SessionController {

    private final SessionService service;
    private final UserService userService;

    @PostMapping
    public void create(@RequestBody SessionRequest request) {
        var session = from(request);

        service.save(session);
    }

    private Session from(SessionRequest request) {
        var session = new Session();
        var date = request.getDate();

        session.setCustomer(userService.findById(request.getCustomerId()));
        session.setProfessional(userService.findById(request.getProfessionalId()));

        if (request.getType() == SINGLE) {
            session.setOccurrenceDate(date);
        } else {
            session.setDayOfWeek(date.getDayOfWeek());
            session.setRecurrentTime(date.toLocalTime());
        }

        return session;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
