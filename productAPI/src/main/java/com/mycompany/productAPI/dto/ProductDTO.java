package com.mycompany.productAPI.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {
	private String productId;
	private String name;
	private int price;
	private String content;
	private int hitCount;
	private int status;
	private Date regDate;
	private String brandName;
	private List<String> colorList;
	private List<String> colorChipList;
	private ProductDetailDTO productDetail;
}
