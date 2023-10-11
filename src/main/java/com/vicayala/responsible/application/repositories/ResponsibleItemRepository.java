package com.vicayala.responsible.application.repositories;

import com.vicayala.responsible.infrastructure.db.entities.responsible.ResponsibleItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ResponsibleItemRepository extends CrudRepository<ResponsibleItemEntity, String> {
}
