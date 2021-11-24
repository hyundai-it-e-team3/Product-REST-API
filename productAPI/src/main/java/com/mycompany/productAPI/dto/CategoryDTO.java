package com.mycompany.productAPI.dto;

import lombok.Data;

@Data
public class CategoryDTO {
	private String categoryId;
	private String parentCategoryId;
	private String name;
	private int level;
}
