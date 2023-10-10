package com.vicayala.responsible.application.repositories;

import com.vicayala.responsible.infrastructure.bd.entities.responsible.ResponsibleItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ResponsibleItemRepository extends CrudRepository<ResponsibleItemEntity, String> {
}
