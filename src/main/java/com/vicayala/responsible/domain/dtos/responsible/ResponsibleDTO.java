package com.vicayala.responsible.domain.dtos.responsible;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonTypeInfo(use= JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ContractEmployeeResponsibleDTO.class, name = ContractEmployeeResponsibleDTO.TYPE),
        @JsonSubTypes.Type(value = InHouseEmployeeResponsibleDTO.class, name = InHouseEmployeeResponsibleDTO.TYPE),
        @JsonSubTypes.Type(value = BranchResponsibleDTO.class, name = BranchResponsibleDTO.TYPE)
})
public abstract class ResponsibleDTO{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    private String id;
}
