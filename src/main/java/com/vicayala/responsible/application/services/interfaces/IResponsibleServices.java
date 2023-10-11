package com.vicayala.responsible.application.services.interfaces;

import com.vicayala.responsible.infrastructure.db.entities.responsible.ResponsibleEntity;
import com.vicayala.responsible.infrastructure.db.entities.responsible.ResponsibleItemEntity;

import java.util.Optional;

public interface IResponsibleServices {

    Optional<ResponsibleEntity> save(ResponsibleEntity responsibleEntity);
    Optional<ResponsibleItemEntity>  getById(String id);

}
