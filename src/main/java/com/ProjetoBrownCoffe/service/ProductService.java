package com.ProjetoBrownCoffe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoBrownCoffe.entities.Product;
import com.ProjetoBrownCoffe.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	public List<Product> buscaTodosProducts(){
		return productRepository.findAll();
	}
	public Product buscaProductId(Long id) {
		Optional <Product> existeProduct = productRepository.findById(id);
		return existeProduct.orElse(null);
	}
	public Product salvaProduct(Product product) {
		return productRepository.save(product);		
	}
	public Product alterarProduct(Long id, Product alterarProduct) {
		Optional <Product> existeProduct = productRepository.findById(id);
		if (existeProduct.isPresent()) {
			alterarProduct.setId(id);;
			return productRepository.save(alterarProduct);
		}
		return null;
	}
	public boolean apagarProduct(Long id) {
		Optional <Product> existeProduct = productRepository.findById(id);
		if (existeProduct.isPresent()) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
}