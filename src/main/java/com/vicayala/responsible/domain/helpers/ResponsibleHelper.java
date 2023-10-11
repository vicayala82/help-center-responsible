package com.vicayala.responsible.domain.helpers;

import com.vicayala.responsible.application.exceptions.NotFoundResponsibleExceptions;
import com.vicayala.responsible.application.services.interfaces.IResponsibleServices;
import com.vicayala.responsible.domain.dtos.responsible.BranchResponsibleDTO;
import com.vicayala.responsible.domain.dtos.responsible.ContractEmployeeResponsibleDTO;
import com.vicayala.responsible.domain.dtos.responsible.InHouseEmployeeResponsibleDTO;
import com.vicayala.responsible.domain.dtos.responsible.ResponsibleDTO;
import com.vicayala.responsible.infrastructure.db.entities.responsible.BranchResponsibleEntity;
import com.vicayala.responsible.infrastructure.db.entities.responsible.ContractEmployeeResponsibleEntity;
import com.vicayala.responsible.infrastructure.db.entities.responsible.InHouseEmployeeResponsibleEntity;
import com.vicayala.responsible.infrastructure.db.entities.responsible.ResponsibleItemEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ResponsibleHelper {

    @Autowired
    private final IResponsibleServices responsibleServices;

    public ResponsibleDTO save(ResponsibleDTO responsibleDTO){

       if(responsibleDTO instanceof BranchResponsibleDTO){
           BranchResponsibleEntity responsibleEntity = (BranchResponsibleEntity)(responsibleServices
                .save(BranchResponsibleDTO
                    .ToEntity((BranchResponsibleDTO)responsibleDTO)).orElseThrow());
            return BranchResponsibleEntity.toDto(responsibleEntity);
        }
        if(responsibleDTO instanceof ContractEmployeeResponsibleDTO){
            ContractEmployeeResponsibleEntity responsibleEntity = (ContractEmployeeResponsibleEntity)(responsibleServices
                    .save(ContractEmployeeResponsibleDTO
                        .toEntity((ContractEmployeeResponsibleDTO) responsibleDTO)).orElseThrow());
            return ContractEmployeeResponsibleEntity.toDto(responsibleEntity);
        }
        if(responsibleDTO instanceof InHouseEmployeeResponsibleDTO){
            InHouseEmployeeResponsibleEntity responsibleEntity =
               (InHouseEmployeeResponsibleEntity) (responsibleServices
                  .save(InHouseEmployeeResponsibleDTO
                      .toEntity((InHouseEmployeeResponsibleDTO) responsibleDTO)).orElseThrow());
            return InHouseEmployeeResponsibleEntity.toDto(responsibleEntity);
        }
        throw new HttpMessageConversionException(HttpStatus.BAD_REQUEST.name());
    }

    public ResponsibleDTO getForId(String id){
        ResponsibleItemEntity responsibleItemEntity = responsibleServices.getById(id).orElseThrow();
        if(responsibleItemEntity.getResponsibleType().equals(BranchResponsibleEntity.TYPE)){
            return ResponsibleItemEntity.toBranchDto(responsibleItemEntity);
        }
        if(responsibleItemEntity.getResponsibleType().equals(InHouseEmployeeResponsibleEntity.TYPE)){
            return ResponsibleItemEntity.toInHouseDto(responsibleItemEntity);
        }
        if (responsibleItemEntity.getResponsibleType().equals(ContractEmployeeResponsibleEntity.TYPE)){
            return ResponsibleItemEntity.toContractorDto(responsibleItemEntity);
        }
        throw new NotFoundResponsibleExceptions();
    }
}

