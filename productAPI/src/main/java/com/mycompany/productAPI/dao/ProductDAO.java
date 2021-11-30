package com.mycompany.productAPI.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.productAPI.dto.ProductDTO;

@Mapper
public interface ProductDAO {

	public ProductDTO selectByProductId(String productId);

	public int selectAllProductByBrandName(String brandName);

	public int selectCountByBrandName(Map<String,String> map);
	
	public int selectCountByCategoryId(String categoryId);
	
	public int selectAllCount();
	
	

	public List<ProductDTO> selectProductListByBrandName(Map<String, Object> mp);

	public List<ProductDTO> selectAllProductList(Map<String, Object> mp);
	
	public List<ProductDTO> selectProductListByCategoryId(Map<String, Object> mp);

	public int updateHitCount(String productId);


}
