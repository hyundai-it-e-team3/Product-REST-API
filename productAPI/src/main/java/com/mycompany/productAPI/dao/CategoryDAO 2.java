package com.mycompany.productAPI.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.productAPI.dto.CategoryDTO;

@Mapper
public interface CategoryDAO {

	public List<CategoryDTO> selectAllMain();
	
	public List<CategoryDTO> selectAllMiddle();
	
	public List<CategoryDTO> selectAllSub();

	public List<CategoryDTO> selecMiddleCategoryById(String mainCategoryId);

	public List<CategoryDTO> selectSubCategory(String parentCategoryId);

	public List<CategoryDTO> selectAllCategory();


}
