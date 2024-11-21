package com.ProjetoBrownCoffe.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoBrownCoffe.entities.Product;
import com.ProjetoBrownCoffe.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Product")
public class ProductController {

	private final ProductService ProductService;

	@Autowired
	public ProductController(ProductService ProductService) {
		this.ProductService = ProductService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> buscaProductControlId(@PathVariable Long id){
		Product Product  = ProductService.buscaProductId(id);
		if(Product != null) {
			return ResponseEntity.ok(Product);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping
	public ResponseEntity<List<Product>> buscaTodosProductsControl(){
		List<Product> Products = ProductService.buscaTodosProducts();
		return ResponseEntity.ok(Products);
	}

	@PostMapping
	public ResponseEntity<Product> salvaProductsControl(@RequestBody @Valid Product Product){
		Product salvaProduct = ProductService.salvaProduct(Product);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduct);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> alteraProductControl(@PathVariable Long id, @RequestBody @Valid Product Product){
		Product alteraProduct = ProductService.alterarProduct(id, Product);
		if(alteraProduct != null) {
			return ResponseEntity.ok(Product);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaProductControl(@PathVariable Long id){
		boolean apagar = ProductService.apagarProduct(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Product foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
