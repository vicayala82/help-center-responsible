package com.vicayala.responsible.application.repositories;

import com.vicayala.responsible.infrastructure.db.entities.responsible.ResponsibleItemEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ResponsibleItemRepository extends CrudRepository<ResponsibleItemEntity, String> {
}
