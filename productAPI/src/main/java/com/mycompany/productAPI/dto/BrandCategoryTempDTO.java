package com.mycompany.productAPI.dto;

import java.util.List;

import lombok.Data;

@Data
public class BrandCategoryTempDTO {
	private String brandName;
	private String categoryId;
	private String parentCategoryId;
	private String name;
	private int clevel;
	private List<BrandCategoryTempDTO> categoryList;
}
