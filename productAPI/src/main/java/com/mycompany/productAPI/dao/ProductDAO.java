package com.mycompany.productAPI.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.productAPI.dto.ProductDTO;

@Mapper
public interface ProductDAO {

	public ProductDTO selectByProductId(String productId);

}
