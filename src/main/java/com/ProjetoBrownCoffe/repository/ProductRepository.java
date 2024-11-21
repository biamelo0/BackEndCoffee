package com.ProjetoBrownCoffe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoBrownCoffe.entities.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {

}
