package com.vicayala.responsible.application.repositories;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.vicayala.responsible.infrastructure.bd.entities.responsible.ResponsibleItemEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
@Slf4j
public class ResponsibleCrud {

    DynamoDBMapper dynamoDBMapper;
    AmazonDynamoDB amazonDynamoDB;

    public Optional<ResponsibleItemEntity>  findById (String id){

    try {
        ResponsibleItemEntity responsible =this.dynamoDBMapper
                .load(ResponsibleItemEntity.class, id,
                        new DynamoDBMapperConfig(DynamoDBMapperConfig.ConsistentReads.CONSISTENT));
        return Optional.of(responsible);
    }catch (Exception ex){
        log.error(ex.getMessage());
        return Optional.empty();
    }
    }
}
