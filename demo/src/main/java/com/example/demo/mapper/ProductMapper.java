package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;

@Mapper(componentModel = "spring")
@Named("ProductMapper")
public interface ProductMapper {
	ProductDto entityToDto(Product product);
    Product dtoToEntity(ProductDto dto);
}
