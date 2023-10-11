package com.vicayala.responsible.infrastructure.db.entities.responsible;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vicayala.responsible.domain.dtos.responsible.BranchResponsibleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@DynamoDBTable(tableName = "help-center-responsible")
public class BranchResponsibleEntity extends ResponsibleEntity implements Serializable {
    @JsonIgnore
    public static final String TYPE = "branch";

    @DynamoDBAttribute(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "city")
    private String city;
    @DynamoDBAttribute(attributeName = "address")
    private String address;

    public static BranchResponsibleDTO toDto(BranchResponsibleEntity branchResponsibleEntity) {
        BranchResponsibleDTO branchResponsibleDTO =
                BranchResponsibleDTO.builder().build();
        BeanUtils.copyProperties(branchResponsibleEntity, branchResponsibleDTO);
        return branchResponsibleDTO;
    }
}
