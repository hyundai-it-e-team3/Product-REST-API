package com.mycompany.productAPI.dto;

import java.util.List;

import lombok.Data;

@Data
public class BrandCategoryDTO {
	private String brandName;
	private String mainImg;
	private List<BrandCategoryTempDTO> brandCategoryTempList;
}