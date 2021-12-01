package com.mycompany.productAPI.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.productAPI.dao.ProductDAO;
import com.mycompany.productAPI.dao.ProductDetailDAO;
import com.mycompany.productAPI.dao.ProductImgDAO;
import com.mycompany.productAPI.dao.StockDAO;
import com.mycompany.productAPI.dto.ProductDTO;
import com.mycompany.productAPI.dto.ProductDetailDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		
		productDAO.updateHitCount(productId);
		
		ProductDTO productDTO = productDAO.selectByProductId(productId);
		log.info(productId);
		productDTO.setProductDetailList(productDetailDAO.selectAllByProductId(productId));
		
		for(ProductDetailDTO productDetail: productDTO.getProductDetailList()) {
			productDetail.setStockList(stockDAO.selectByProductDetailId(productDetail.getProductDetailId()));
			productDetail.setImgList(productImgDAO.selectByProductDetailId(productDetail.getProductDetailId()));
			productDetail.setWithImgList(productImgDAO.selectByProductDetailId(productDetail.getWithProduct()));
		}		
		return productDTO;
	}

	public int getRowCount(String brandName, String categoryId) {
		Map<String,String> mp = new HashMap<>();
		mp.put("brandName",brandName);
		mp.put("categoryId",categoryId);
		return productDAO.selectCountByBrandName(mp);
	}

	public List<ProductDTO> getBrandProductList(String brandName,String categoryId ,int startRow, int endRow, int sortId) {
		Map<String,Object> mp = new HashMap<>();
		mp.put("brandName",brandName);
		mp.put("startRow",startRow);
		mp.put("endRow",endRow);
		mp.put("categoryId",categoryId);
		
		if(sortId==0) {
			mp.put("sortId","reg_date");
			mp.put("sortWay","asc");
		}else if(sortId==1){
			mp.put("sortId","price");
			mp.put("sortWay","asc");
		}else if(sortId==2){
			mp.put("sortId","price");
			mp.put("sortWay","desc");
		}
		return productDAO.selectProductListByBrandName(mp);
	
	}

	public int getRowCountByCategory(String categoryId) {	
		if(categoryId.equals("0"))
			return productDAO.selectAllCount();
		return productDAO.selectCountByCategoryId(categoryId);
	}

	public List<ProductDTO> getCategoryProductList(String categoryId, int startRow, int endRow, int sortId) {
		
		Map<String,Object> mp = new HashMap<>();
		
		mp.put("categoryId",categoryId);
		mp.put("startRow",startRow);
		mp.put("endRow",endRow);
		
		if(sortId==0) {
			mp.put("sortId","reg_date");
			mp.put("sortWay","desc");
		}else if(sortId==1){
			mp.put("sortId","price");
			mp.put("sortWay","asc");
		}else if(sortId==2){
			mp.put("sortId","price");
			mp.put("sortWay","desc");
		}else{
			mp.put("sortId","hit_count");
			mp.put("sortWay","desc");
		}
		
		
		log.info(categoryId+" "+startRow+" "+endRow+" "+sortId);
		if(categoryId.equals("0"))
			return productDAO.selectAllProductList(mp);
		return productDAO.selectProductListByCategoryId(mp);
	}

}
