package com.nttdata.passiveproducts.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nttdata.passiveproducts.domain.Account;
import com.nttdata.passiveproducts.web.model.AccountModel;

@Mapper(componentModel = "spring")
public interface AccountMapper {

	Account modelToEntity(AccountModel model);

	AccountModel entityToModel(Account event);

	@Mapping(target = "accountId", ignore = true)
	void update(@MappingTarget Account entity, Account updateEntity);

}
