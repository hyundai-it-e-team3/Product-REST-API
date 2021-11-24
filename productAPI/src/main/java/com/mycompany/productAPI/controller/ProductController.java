package com.mycompany.productAPI.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.productAPI.dto.ProductDTO;
import com.mycompany.productAPI.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
	
	@Resource
	private ProductService productService;
	
	@RequestMapping("/{productId}")
	public ProductDTO getProduct(@PathVariable String productId){
		return productService.getProduct(productId);
	}
}
