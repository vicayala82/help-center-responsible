package com.vicayala.responsible.domain.dtos.responsible;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vicayala.responsible.infrastructure.bd.entities.responsible.InHouseEmployeeResponsibleEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
public class InHouseEmployeeResponsibleDTO extends EmployeeResponsibleDTO{
    @JsonIgnore
    public static final String TYPE = "in_house";
    @JsonProperty("contract_type")
    private String contractType;
    private String position;
    @JsonProperty("corporate_Email")
    private String corporateEmail;
    private BigDecimal salary;

    public static InHouseEmployeeResponsibleEntity
        toEntity(InHouseEmployeeResponsibleDTO inHouseEmployeeResponsibleDTO){
        InHouseEmployeeResponsibleEntity inHouseEmployeeResponsibleEntity =InHouseEmployeeResponsibleEntity.builder()
                .responsibleType(InHouseEmployeeResponsibleEntity.TYPE).build();
        BeanUtils.copyProperties(inHouseEmployeeResponsibleDTO, inHouseEmployeeResponsibleEntity);
        inHouseEmployeeResponsibleEntity
            .setCompany(CompanyDTO.toEntity(inHouseEmployeeResponsibleDTO.getCompany()));
        return  inHouseEmployeeResponsibleEntity;
    }

}
