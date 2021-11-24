package com.mycompany.productAPI.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.productAPI.dto.CategoryDTO;

@Mapper
public interface CategoryDAO {

	public List<CategoryDTO> selectAllMain();

	public List<CategoryDTO> selectMiddleCategoryById(String mainCategoryId);

	public List<CategoryDTO> selectSubCategory(String parentCategoryId);

}
