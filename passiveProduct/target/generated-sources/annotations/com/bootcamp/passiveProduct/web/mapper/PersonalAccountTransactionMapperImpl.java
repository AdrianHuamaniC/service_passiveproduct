package com.bootcamp.passiveProduct.web.mapper;

import com.bootcamp.passiveProduct.domain.PersonalAccountTransaction;
import com.bootcamp.passiveProduct.web.model.PersonalAccountTransactionModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-16T08:46:32-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@Component
public class PersonalAccountTransactionMapperImpl implements PersonalAccountTransactionMapper {

    @Override
    public PersonalAccountTransaction modelToEntity(PersonalAccountTransactionModel model) {
        if ( model == null ) {
            return null;
        }

        PersonalAccountTransaction.PersonalAccountTransactionBuilder personalAccountTransaction = PersonalAccountTransaction.builder();

        personalAccountTransaction.id( model.getId() );
        personalAccountTransaction.sourceAccount( model.getSourceAccount() );
        personalAccountTransaction.destinyAccount( model.getDestinyAccount() );
        personalAccountTransaction.destinyAccountType( model.getDestinyAccountType() );
        personalAccountTransaction.movementType( model.getMovementType() );
        personalAccountTransaction.amount( model.getAmount() );
        personalAccountTransaction.chanelTypeId( model.getChanelTypeId() );

        return personalAccountTransaction.build();
    }

    @Override
    public PersonalAccountTransactionModel entityToModel(PersonalAccountTransaction event) {
        if ( event == null ) {
            return null;
        }

        PersonalAccountTransactionModel.PersonalAccountTransactionModelBuilder personalAccountTransactionModel = PersonalAccountTransactionModel.builder();

        personalAccountTransactionModel.id( event.getId() );
        personalAccountTransactionModel.sourceAccount( event.getSourceAccount() );
        personalAccountTransactionModel.destinyAccount( event.getDestinyAccount() );
        personalAccountTransactionModel.destinyAccountType( event.getDestinyAccountType() );
        personalAccountTransactionModel.movementType( event.getMovementType() );
        personalAccountTransactionModel.amount( event.getAmount() );
        personalAccountTransactionModel.chanelTypeId( event.getChanelTypeId() );

        return personalAccountTransactionModel.build();
    }

    @Override
    public void update(PersonalAccountTransaction entity, PersonalAccountTransaction updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setSourceAccount( updateEntity.getSourceAccount() );
        entity.setDestinyAccount( updateEntity.getDestinyAccount() );
        entity.setDestinyAccountType( updateEntity.getDestinyAccountType() );
        entity.setTransactionDate( updateEntity.getTransactionDate() );
        entity.setMovementType( updateEntity.getMovementType() );
        entity.setCurrrency( updateEntity.getCurrrency() );
        entity.setAmount( updateEntity.getAmount() );
        entity.setCommision( updateEntity.getCommision() );
        entity.setTotalAmount( updateEntity.getTotalAmount() );
        entity.setChanelTypeId( updateEntity.getChanelTypeId() );
    }
}
