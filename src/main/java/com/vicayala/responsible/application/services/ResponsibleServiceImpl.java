package com.vicayala.responsible.application.services;

import com.vicayala.responsible.application.repositories.ResponsibleItemRepository;
import com.vicayala.responsible.application.repositories.ResponsibleRepository;
import com.vicayala.responsible.application.services.interfaces.IResponsibleServices;
import com.vicayala.responsible.infrastructure.bd.entities.responsible.ResponsibleEntity;
import com.vicayala.responsible.infrastructure.bd.entities.responsible.ResponsibleItemEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ResponsibleServiceImpl implements IResponsibleServices {

    private final ResponsibleRepository responsibleRepository;
    private final ResponsibleItemRepository responsibleItemRepository;

    public Optional<ResponsibleEntity>  save(ResponsibleEntity responsible){
        return Optional.of(responsibleRepository.save(responsible));
    }

    @Override
    public Optional<ResponsibleItemEntity> getById(String id) {
        return responsibleItemRepository.findById(id);
    }
}
