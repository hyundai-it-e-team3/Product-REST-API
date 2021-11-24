package com.mycompany.productAPI.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.productAPI.dto.StockDTO;

@Mapper
public interface StockDAO {
	public StockDTO selectByStockDTO(StockDTO stockDTO);
	public List<StockDTO> selectByProductDetailId(String productDetailId);
	public int updatePlusByStockDTO(StockDTO stockDTO);
	public int updateMinusByStockDTO(StockDTO stockDTO);
}
