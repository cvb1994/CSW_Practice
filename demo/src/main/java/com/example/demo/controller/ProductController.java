package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class ProductController {
	@Autowired
	private ProductService productSer;
	
	@GetMapping(value = "/{list}")
	public ResponseEntity<?> getList(){
		List<ProductDto> list = productSer.getList();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/save")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto dto){
    	System.out.println("da vao day");
    	productSer.save(dto);
		return ResponseEntity.ok("Success");
    }
	
	@PostMapping(value = "/sell")
	public ResponseEntity<?> sellProduct(@RequestParam("id") int id, @RequestParam("quantity") int quantity){
    	System.out.println("da vao day");
    	ProductDto currentProduct = productSer.getProduct(id);
    	if(quantity <= currentProduct.getQuantity()) {
    		int quantityLeft = currentProduct.getQuantity() - quantity;
    		currentProduct.setQuantity(quantityLeft);
    		productSer.save(currentProduct);
    		return ResponseEntity.ok("Success");
    	}
    	return ResponseEntity.ok("Fail"); 
    } 

}
