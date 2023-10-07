package com.vicayala.responsible.domain.dtos.responsible;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vicayala.responsible.infrastructure.bd.entities.responsible.BranchResponsibleEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
public class BranchResponsibleDTO extends ResponsibleDTO {
    @JsonIgnore
    public static final String TYPE = "branch";
    private String name;
    private String city;
    private String address;

    public static BranchResponsibleEntity ToEntity(BranchResponsibleDTO branchResponsibleDTO){
        BranchResponsibleEntity branchResponsibleEntity = BranchResponsibleEntity.builder()
                    .responsibleType(BranchResponsibleEntity.TYPE).build();
        BeanUtils.copyProperties(branchResponsibleDTO, branchResponsibleEntity);
        return branchResponsibleEntity;
    }
}
