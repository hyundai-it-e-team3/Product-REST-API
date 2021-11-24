package com.mycompany.productAPI.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.productAPI.dao.ProductDetailDAO;
import com.mycompany.productAPI.dao.ProductImgDAO;
import com.mycompany.productAPI.dao.StockDAO;
import com.mycompany.productAPI.dto.ProductDetailDTO;
import com.mycompany.productAPI.dto.StockDTO;

@Service
public class ProductDetailService {

	@Resource
	private ProductDetailDAO productDetailDAO;
	
	@Resource
	private StockDAO stockDAO;
	
	@Resource
	private ProductImgDAO productImgDAO;
	
	public ProductDetailDTO getProductDetail(String productDetailId) {
		ProductDetailDTO productDetailDTO = productDetailDAO.selectByProductDetailId(productDetailId);
		productDetailDTO.setStockList(stockDAO.selectByProductDetailId(productDetailId));
		productDetailDTO.setImgList(productImgDAO.selectByProductDetailId(productDetailId));
		
		return productDetailDTO;
	}

}
