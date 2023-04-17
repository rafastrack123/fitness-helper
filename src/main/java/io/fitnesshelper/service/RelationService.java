package io.fitnesshelper.service;

import io.fitnesshelper.entity.Relation;
import io.fitnesshelper.entity.User;
import io.fitnesshelper.repository.RelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelationService {

    private final RelationRepository repository;
    private final UserService userService;

    public void create(Long professionalId, Long customerId) {
        var relation = new Relation();

        relation.setProfessional(getUser(professionalId));
        relation.setCustomer(getUser(customerId));

        repository.save(relation);
    }

    public boolean existsRelation(User customer, User professional) {
        return repository.countAllByCustomerAndProfessional(customer, professional) > 0;
    }

    private User getUser(Long userId) {
        return userService.findById(userId);
    }
}
