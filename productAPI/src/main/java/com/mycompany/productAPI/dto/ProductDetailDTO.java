package com.mycompany.productAPI.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductDetailDTO {
	private String productDetailId;
	private String withProduct;
	private String colorCode;
	private String colorChip;
	private String productId;
	private List<ProductImgDTO> imgList;
	private List<StockDTO> stockList;
}
