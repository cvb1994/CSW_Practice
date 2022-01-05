package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductMapper productMapper;
	
	public ProductDto getProduct(int id) {
		return productRepo.findById(id).map(productMapper::entityToDto).orElse(null);
	}
	
	public List<ProductDto> getList(){
		return productRepo.findAll().stream().map(productMapper::entityToDto).collect(Collectors.toList());
	}
	
	public ProductDto save(ProductDto productDto) {
		Product product = Optional.ofNullable(productDto).map(productMapper::dtoToEntity).orElse(null);
		if(product != null) {
			return Optional.ofNullable(productRepo.save(product)).map(productMapper::entityToDto).orElse(null);
		}
		return null;
	}
}
