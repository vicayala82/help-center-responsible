package com.vicayala.responsible.infrastructure.db.entities.responsible;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.vicayala.responsible.domain.dtos.responsible.ContractEmployeeResponsibleDTO;
import com.vicayala.responsible.domain.dtos.responsible.InHouseEmployeeResponsibleDTO;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Setter
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@JsonSubTypes({
        @JsonSubTypes.Type(value = ContractEmployeeResponsibleEntity.class, name = ContractEmployeeResponsibleDTO.TYPE),
        @JsonSubTypes.Type(value = InHouseEmployeeResponsibleEntity.class, name = InHouseEmployeeResponsibleDTO.TYPE)
})
public abstract class EmployeeResponsibleEntity extends ResponsibleEntity implements Serializable {


    private String fullName;
    private String personalEmail;
    private String documentType;
    private String documentNumber;
    private CompanyEntity company;

    @DynamoDBAttribute(attributeName = "fullName")
    public String getFullName() {
        return this.fullName;
    }
    @DynamoDBAttribute(attributeName = "personalEmail")
    public String getPersonalEmail() {
        return this.personalEmail;
    }
    @DynamoDBAttribute(attributeName = "documentType")
    public String getDocumentType() {
        return this.documentType;
    }

    @DynamoDBAttribute(attributeName = "documentNumber")
    public String getDocumentNumber() {
        return this.documentNumber;
    }

    @DynamoDBAttribute(attributeName = "company")
    public CompanyEntity getCompany() {
        return this.company;
    }
}
