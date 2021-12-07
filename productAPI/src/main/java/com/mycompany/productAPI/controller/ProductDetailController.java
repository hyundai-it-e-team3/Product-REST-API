package com.mycompany.productAPI.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.productAPI.dto.ProductDetailDTO;
import com.mycompany.productAPI.service.ProductDetailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/productDetail")
public class ProductDetailController {
	
	@Resource
	private ProductDetailService productDetailService;
	
	@RequestMapping("/{productDetailId}")
	public ProductDetailDTO getProductDetail(@PathVariable String productDetailId) {
		return productDetailService.getProductDetail(productDetailId);
	}
	
	
	@RequestMapping("/price/{productDetailId}")
	public int getPrice(@PathVariable String productDetailId) {
		return productDetailService.getPrice(productDetailId);
	}
	
}
