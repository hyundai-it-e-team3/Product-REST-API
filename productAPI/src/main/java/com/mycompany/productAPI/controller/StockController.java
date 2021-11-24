package com.mycompany.productAPI.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.productAPI.dto.StockDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/stock")
public class StockController {
	

	
	@RequestMapping("/{productDetailId}")
	public Map getStock(@PathVariable("productDetailId") String productDetailId) {
		StockDTO stockDTO = 
		return mp;
	}
}
