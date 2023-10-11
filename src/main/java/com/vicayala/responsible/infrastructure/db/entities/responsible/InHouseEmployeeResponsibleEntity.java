package com.vicayala.responsible.infrastructure.db.entities.responsible;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vicayala.responsible.domain.dtos.responsible.InHouseEmployeeResponsibleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@DynamoDBTable(tableName = "help-center-responsible")
public class InHouseEmployeeResponsibleEntity extends EmployeeResponsibleEntity implements Serializable {

    @JsonIgnore
    public static final String TYPE = "in_house";

    @DynamoDBAttribute(attributeName = "contractType")
    private String contractType;
    @DynamoDBAttribute(attributeName = "position")
    private String position;
    @DynamoDBAttribute(attributeName = "corporateEmail")
    private String corporateEmail;
    @DynamoDBAttribute(attributeName = "salary")
    private BigDecimal salary;

    public static InHouseEmployeeResponsibleDTO
    toDto(InHouseEmployeeResponsibleEntity inHouseEmployeeResponsibleEntity) {
        InHouseEmployeeResponsibleDTO inHouseEmployeeResponsibleDTO =
                InHouseEmployeeResponsibleDTO.builder().build();
        BeanUtils.copyProperties(inHouseEmployeeResponsibleEntity, inHouseEmployeeResponsibleDTO);
        inHouseEmployeeResponsibleDTO
                .setCompany(CompanyEntity.toDto(inHouseEmployeeResponsibleEntity.getCompany()));
        return inHouseEmployeeResponsibleDTO;
    }

}
