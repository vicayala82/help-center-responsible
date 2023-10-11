package com.vicayala.responsible.infrastructure.db.entities.responsible;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vicayala.responsible.domain.dtos.responsible.ContractEmployeeResponsibleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@DynamoDBTable(tableName = "help-center-responsible")
public class ContractEmployeeResponsibleEntity extends EmployeeResponsibleEntity implements Serializable {

    @JsonIgnore
    public static final String TYPE = "contract";
    @DynamoDBAttribute(attributeName = "serviceDescription")
    private String serviceDescription;
    @DynamoDBAttribute(attributeName = "endedDateService")
    private Date endedDateService;
    @DynamoDBAttribute(attributeName = "serviceTotalPayment")
    private BigDecimal serviceTotalPayment;

    @DynamoDBAttribute(attributeName = "currency")
    private String currency;

    public static ContractEmployeeResponsibleDTO
    toDto(ContractEmployeeResponsibleEntity contractEmployeeResponsibleEntity) {
        ContractEmployeeResponsibleDTO contractEmployeeResponsibleDTO =
                ContractEmployeeResponsibleDTO.builder().build();
        BeanUtils.copyProperties(contractEmployeeResponsibleEntity, contractEmployeeResponsibleDTO);
        contractEmployeeResponsibleDTO
            .setCompany(CompanyEntity.toDto(contractEmployeeResponsibleEntity.getCompany()));
        contractEmployeeResponsibleDTO.setEndedDateService(contractEmployeeResponsibleEntity
                .getEndedDateService().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return contractEmployeeResponsibleDTO;
    }
}
