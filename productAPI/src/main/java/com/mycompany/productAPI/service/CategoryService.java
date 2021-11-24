package com.mycompany.productAPI.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.productAPI.dao.CategoryDAO;
import com.mycompany.productAPI.dto.CategoryDTO;

@Service
public class CategoryService {
	
	
	@Resource
	private CategoryDAO categoryDAO;
	
	public List<CategoryDTO> getMainCategory(){
		return categoryDAO.selectAllMain();
	}

	public List<CategoryDTO> getMiddleCategory(String mainCategoryId) {
		return categoryDAO.selectMiddleCategoryById(mainCategoryId);
	}

	public List<CategoryDTO> getSubCategory(String parentCategoryId) {
		return categoryDAO.selectSubCategory(parentCategoryId);
	}
}
