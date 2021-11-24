package com.mycompany.productAPI.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.productAPI.dto.StockDTO;

@Mapper
public interface StockDAO {
	public StockDTO selectByStockDTO(StockDTO stockDTO);
	public int updateByStockDTO(StockDTO stockDTO);
}
