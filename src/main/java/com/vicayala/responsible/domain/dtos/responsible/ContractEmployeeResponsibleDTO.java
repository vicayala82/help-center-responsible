package com.vicayala.responsible.domain.dtos.responsible;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vicayala.responsible.infrastructure.bd.entities.responsible.BranchResponsibleEntity;
import com.vicayala.responsible.infrastructure.bd.entities.responsible.ContractEmployeeResponsibleEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class ContractEmployeeResponsibleDTO extends EmployeeResponsibleDTO{
    @JsonIgnore
    public static final String TYPE = "contract";
    @JsonProperty("service_description")
    private String serviceDescription;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("ended_date_service")
    private LocalDate endedDateService;
    @JsonProperty("service_total_payment")
    private BigDecimal serviceTotalPayment;
    private String currency;

    public static ContractEmployeeResponsibleEntity
        toEntity(ContractEmployeeResponsibleDTO contractEmployeeResponsibleDTO){
        ContractEmployeeResponsibleEntity contractEmployeeResponsibleEntity =ContractEmployeeResponsibleEntity
                .builder().responsibleType(ContractEmployeeResponsibleEntity.TYPE).build();
        BeanUtils.copyProperties(contractEmployeeResponsibleDTO, contractEmployeeResponsibleEntity);
        contractEmployeeResponsibleEntity
            .setCompany(CompanyDTO.toEntity(contractEmployeeResponsibleDTO.getCompany()));
        contractEmployeeResponsibleEntity.setEndedDateService(Date.from(contractEmployeeResponsibleDTO
                .getEndedDateService().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        return  contractEmployeeResponsibleEntity;
    }
}
