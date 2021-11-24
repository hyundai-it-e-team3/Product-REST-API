package com.mycompany.productAPI.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.productAPI.dao.ProductDAO;
import com.mycompany.productAPI.dao.ProductDetailDAO;
import com.mycompany.productAPI.dao.ProductImgDAO;
import com.mycompany.productAPI.dao.StockDAO;
import com.mycompany.productAPI.dto.ProductDTO;
import com.mycompany.productAPI.dto.ProductDetailDTO;

import lombok.extern.slf4j.Slf4j;

@Service
public class ProductService {
	
	@Resource
	private ProductDAO productDAO;
	
	@Resource
	private ProductDetailDAO productDetailDAO;
	
	@Resource
	private StockDAO stockDAO;
	
	@Resource
	private ProductImgDAO productImgDAO;
	
	public ProductDTO getProduct(String productId) {
		ProductDTO productDTO = productDAO.selectByProductId(productId);
		List<ProductDetailDTO> list = productDetailDAO.selectAllByProductId(productId);
		
		ProductDetailDTO productDetailDTO = list.get(0);
		productDetailDTO.setStockList(stockDAO.selectByProductDetailId(productDetailDTO.getProductDetailId()));
		productDetailDTO.setImgList(productImgDAO.selectByProductDetailId(productDetailDTO.getProductDetailId()));
		
		productDTO.setColorList(new ArrayList<>());
		productDTO.setColorChipList(new ArrayList<>());
		productDTO.setProductDetail(productDetailDTO);
		
		for(ProductDetailDTO productDetail : list) {
			productDTO.getColorList().add(productDetail.getColorCode());
			productDTO.getColorChipList().add(productDetail.getColorChip());
		}
		return productDTO;
	}

}
