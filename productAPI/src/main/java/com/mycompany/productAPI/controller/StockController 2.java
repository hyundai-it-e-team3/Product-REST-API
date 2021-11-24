package com.mycompany.productAPI.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.productAPI.dto.StockDTO;
import com.mycompany.productAPI.service.StockService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/stock")
public class StockController {
	
	@Resource
	private StockService stockService;
	
	@RequestMapping("/{productDetailId}/{size}")
	public StockDTO getStock(@PathVariable("productDetailId") String productDetailId, @PathVariable("size") String size) {
		StockDTO stockDTO = new StockDTO();
		stockDTO.setProductDetailId(productDetailId);
		stockDTO.setSize(size);
		log.info(stockDTO.toString());
		return stockService.getStock(stockDTO);
	}
}
