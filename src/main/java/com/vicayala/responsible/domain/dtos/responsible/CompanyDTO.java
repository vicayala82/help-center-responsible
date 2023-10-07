package com.vicayala.responsible.domain.dtos.responsible;

import com.vicayala.responsible.infrastructure.bd.entities.responsible.CompanyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    private String name;
    private String nit;
    private String location;

    public static CompanyEntity toEntity(CompanyDTO companyDTO){
        CompanyEntity companyEntity = CompanyEntity.builder().build();
        BeanUtils.copyProperties(companyDTO,companyEntity);
        return companyEntity;
    }
}
