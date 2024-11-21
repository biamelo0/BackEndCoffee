package com.ProjetoBrownCoffe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@Column(name = "filter", nullable = false, length = 255)
	private String filter;
	
	@Column(name = "imagem_url", nullable = false, length = 255)
	private String imagem_url;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	@Column(name = "price", nullable = false, length = 255)
	private double price;
	
	@Column(name = "rating", nullable = false, length = 255)
	private double rating;
}
