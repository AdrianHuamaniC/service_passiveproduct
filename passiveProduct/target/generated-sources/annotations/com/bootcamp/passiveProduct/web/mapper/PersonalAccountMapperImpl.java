package com.bootcamp.passiveProduct.web.mapper;

import com.bootcamp.passiveProduct.domain.PersonalAccount;
import com.bootcamp.passiveProduct.domain.PersonalAccountTransaction;
import com.bootcamp.passiveProduct.web.model.PersonalAccountModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-16T08:46:32-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@Component
public class PersonalAccountMapperImpl implements PersonalAccountMapper {

    @Override
    public PersonalAccount modelToEntity(PersonalAccountModel model) {
        if ( model == null ) {
            return null;
        }

        PersonalAccount.PersonalAccountBuilder personalAccount = PersonalAccount.builder();

        personalAccount.id( model.getId() );
        personalAccount.accountType( model.getAccountType() );
        personalAccount.currency( model.getCurrency() );
        personalAccount.movementQuantity( model.getMovementQuantity() );
        personalAccount.movementQuantityMax( model.getMovementQuantityMax() );
        personalAccount.movementFrecuency( model.getMovementFrecuency() );
        personalAccount.identityNumberClient( model.getIdentityNumberClient() );
        personalAccount.identityTypeClient( model.getIdentityTypeClient() );

        return personalAccount.build();
    }

    @Override
    public PersonalAccountModel entityToModel(PersonalAccount event) {
        if ( event == null ) {
            return null;
        }

        PersonalAccountModel.PersonalAccountModelBuilder personalAccountModel = PersonalAccountModel.builder();

        personalAccountModel.id( event.getId() );
        personalAccountModel.accountType( event.getAccountType() );
        personalAccountModel.currency( event.getCurrency() );
        personalAccountModel.movementQuantity( event.getMovementQuantity() );
        personalAccountModel.movementQuantityMax( event.getMovementQuantityMax() );
        personalAccountModel.movementFrecuency( event.getMovementFrecuency() );
        personalAccountModel.identityNumberClient( event.getIdentityNumberClient() );
        personalAccountModel.identityTypeClient( event.getIdentityTypeClient() );

        return personalAccountModel.build();
    }

    @Override
    public void update(PersonalAccount entity, PersonalAccount updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setAccountType( updateEntity.getAccountType() );
        entity.setAccountNumber( updateEntity.getAccountNumber() );
        entity.setCci( updateEntity.getCci() );
        entity.setAvailableBalance( updateEntity.getAvailableBalance() );
        entity.setBalance( updateEntity.getBalance() );
        entity.setUserRegisteringId( updateEntity.getUserRegisteringId() );
        entity.setCurrency( updateEntity.getCurrency() );
        entity.setMaintenanceCommision( updateEntity.getMaintenanceCommision() );
        entity.setMovementQuantity( updateEntity.getMovementQuantity() );
        entity.setMovementQuantityMax( updateEntity.getMovementQuantityMax() );
        entity.setMovementFrecuency( updateEntity.getMovementFrecuency() );
        entity.setIdentityNumberClient( updateEntity.getIdentityNumberClient() );
        entity.setIdentityTypeClient( updateEntity.getIdentityTypeClient() );
        entity.setOpeningDate( updateEntity.getOpeningDate() );
        if ( entity.getTransactions() != null ) {
            List<PersonalAccountTransaction> list = updateEntity.getTransactions();
            if ( list != null ) {
                entity.getTransactions().clear();
                entity.getTransactions().addAll( list );
            }
            else {
                entity.setTransactions( null );
            }
        }
        else {
            List<PersonalAccountTransaction> list = updateEntity.getTransactions();
            if ( list != null ) {
                entity.setTransactions( new ArrayList<PersonalAccountTransaction>( list ) );
            }
        }
    }
}
