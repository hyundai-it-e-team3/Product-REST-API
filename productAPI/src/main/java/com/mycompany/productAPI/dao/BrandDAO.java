package com.mycompany.productAPI.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.productAPI.dto.BrandCategoryDTO;
import com.mycompany.productAPI.dto.BrandCategoryTempDTO;
import com.mycompany.productAPI.dto.ProductDTO;
import com.mycompany.productAPI.dto.ProductDetailDTO;

@Mapper
public interface BrandDAO {

	List<ProductDTO> selectMdPickByBrand(String brandName);
	
	List<BrandCategoryDTO> selectAllBrand();

	List<BrandCategoryTempDTO> selectMainBrand();

	List<BrandCategoryTempDTO> selectMiddleBrand();

	List<BrandCategoryTempDTO> selectSubBrand();

}
