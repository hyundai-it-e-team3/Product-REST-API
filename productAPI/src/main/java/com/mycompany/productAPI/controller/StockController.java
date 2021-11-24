package com.mycompany.productAPI.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//GET: stock/CM2B0WSC561W_TN/64
	@RequestMapping("/{productDetailId}/{psize}")
	public StockDTO getStock(@PathVariable("productDetailId") String productDetailId, @PathVariable("psize") String psize) {
		StockDTO stockDTO = new StockDTO();
		stockDTO.setProductDetailId(productDetailId);
		stockDTO.setPsize(psize);

		return stockService.getStock(stockDTO);
	}
	
	//POST: stock/plus
	//requestBody => StockDTO
	@PostMapping("/{type}")
	public Map<String,String> updateStock(@PathVariable String type,StockDTO stockDTO) {

		String result = stockService.updateStock(stockDTO,type);
		Map<String, String> mp = new HashMap<>();
		
		mp.put("result",result);
		
		return mp;
	}
}
