package com.vicayala.responsible.infrastructure.db.entities.responsible;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.vicayala.responsible.domain.dtos.responsible.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Builder
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class CompanyEntity implements Serializable {

    private String name;
    private String nit;
    private String location;

    public static CompanyDTO toDto(CompanyEntity companyEntity){
        CompanyDTO companyDTO = CompanyDTO.builder().build();
        BeanUtils.copyProperties(companyEntity,companyDTO);
        return companyDTO;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return this.name;
    }

    @DynamoDBAttribute(attributeName = "nit")
    public String getNit() {
        return this.nit;
    }

    @DynamoDBAttribute(attributeName = "location")
    public String getLocation() {
        return this.location;
    }
}
