package com.vicayala.responsible.application.repositories;

import com.vicayala.responsible.infrastructure.db.entities.responsible.ResponsibleEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ResponsibleRepository extends CrudRepository<ResponsibleEntity, String> {
    Optional<ResponsibleEntity> findById(String id);
}
