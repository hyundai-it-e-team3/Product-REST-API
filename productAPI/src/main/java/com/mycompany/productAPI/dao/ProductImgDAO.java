package com.mycompany.productAPI.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.productAPI.dto.ProductImgDTO;

@Mapper
public interface ProductImgDAO {

	List<ProductImgDTO> selectByProductDetailId(String productDetailId);

}
