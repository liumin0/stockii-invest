package com.stockii.invest.api;

import com.stockii.invest.api.response.StockBasicInfoResponse;
import com.stockii.invest.service.StockBasicInfo;


public interface StockResponseGenerator {
	StockBasicInfoResponse createStockReponse(StockBasicInfo stock);
}
