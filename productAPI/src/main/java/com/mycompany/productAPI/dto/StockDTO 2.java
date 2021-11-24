package com.mycompany.productAPI.dto;

import lombok.Data;

@Data
public class StockDTO {
	private String size;
	private int amount;
	private String productDetailId;
}
