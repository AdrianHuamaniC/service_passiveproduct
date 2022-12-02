package com.nttdata.passiveproducts.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nttdata.passiveproducts.domain.Customer;
import com.nttdata.passiveproducts.web.model.CustomerModel;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

	 Customer modelToEntity (CustomerModel model);
	 
	 CustomerModel entityToModel (Customer event);
	 
	 @Mapping(target = "clientId", ignore = true)
	 void update(@MappingTarget Customer entity, Customer updateEntity);
}
