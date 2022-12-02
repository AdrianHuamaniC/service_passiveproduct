package com.nttdata.passiveproducts.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nttdata.passiveproducts.domain.Customer;
import com.nttdata.passiveproducts.domain.DebitCard;
import com.nttdata.passiveproducts.web.model.CustomerModel;
import com.nttdata.passiveproducts.web.model.DebitCardModel;

@Mapper(componentModel = "spring")
public interface DebitCardMapper {

	DebitCard modelToEntity (DebitCardModel model);
	
	DebitCardModel entityToModel (DebitCard event);
	
	@Mapping(target = "cardId", ignore = true)
	void update(@MappingTarget DebitCard entity, DebitCard updateEntity);
	
	
}
