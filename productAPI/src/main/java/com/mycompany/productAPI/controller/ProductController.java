package com.mycompany.productAPI.controller;

import java.util.List;

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
	
	@RequestMapping("/brandProductList/{brandName}/{startRow}/{rowCount}/{sortId}")
	public List<ProductDTO> getBrandProductList(@PathVariable("brandName") String brandName,@PathVariable("startRow") int startRow,@PathVariable("rowCount") int rowCount,@PathVariable("sortId") int sortId){
		int totalRows = productService.getRowCount(brandName);
		int endRow = startRow+rowCount;
		if(endRow>totalRows) {
			endRow = totalRows;
		}
		
		return productService.getBrandProductList(brandName,startRow,endRow,sortId);  
	}
	
	@RequestMapping("/list/{categoryId}/{startRow}/{rowCount}/{sortId}")
	public List<ProductDTO> getCategoryProductList(@PathVariable("categoryId") String categoryId,@PathVariable("startRow") int startRow,@PathVariable("rowCount") int rowCount,@PathVariable("sortId") int sortId){
		int totalRows = productService.getRowCountByCategory(categoryId);
		log.info(" "+totalRows);
		int endRow = startRow+rowCount;
		if(endRow>totalRows) {
			endRow = totalRows;
		}
		List <ProductDTO> list = productService.getCategoryProductList(categoryId,startRow,endRow, sortId);
		for(ProductDTO product : list) {
			log.info(product.getProductId());
		}
		return list;
	}
}
