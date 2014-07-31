package com.stockii.invest.service.dao;

import java.util.Date;

import com.cloud.utils.db.GenericDao;
import com.stockii.invest.service.StockBasicInfo;
import com.stockii.invest.service.StockBasicInfoVO;

public interface StockBasicInfoDao extends GenericDao<StockBasicInfoVO, Long> {
	StockBasicInfo createStock(String stockId, String stockName, Date listDate);
}
