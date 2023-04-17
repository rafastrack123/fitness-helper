package io.fitnesshelper.repository;

import io.fitnesshelper.entity.Relation;
import io.fitnesshelper.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RelationRepository extends CrudRepository<Relation, Long> {

    int countAllByCustomerAndProfessional(User customer, User professional);

}

