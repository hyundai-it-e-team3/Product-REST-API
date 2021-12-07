package com.mycompany.productAPI.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.productAPI.dto.ProductDetailDTO;

@Mapper
public interface ProductDetailDAO {

	public ProductDetailDTO selectByProductDetailId(String productDetailId);

	public List<ProductDetailDTO> selectAllByProductId(String productId);

	public int selectPrice(String productDetailId);

}
