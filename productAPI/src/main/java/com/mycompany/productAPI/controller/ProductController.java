package com.mycompany.productAPI.controller;

import java.util.List;
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
	
	@RequestMapping("brandProductList/{brandName}/{startRow}/{rowCount}")
	public List<ProductDTO> getBrandProductList(@PathVariable("brandName") String brandName,@PathVariable("startRow") int startRow,@PathVariable("rowCount") int rowCount){
		int totalRows = productService.getRowCount(brandName);
		int endRow = startRow+rowCount;
		if(endRow>totalRows) {
			endRow = totalRows;
		}
		
		return productService.getBrandProductList(brandName,startRow,endRow);  
	}
}
