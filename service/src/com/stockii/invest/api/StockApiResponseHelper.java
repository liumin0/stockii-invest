package com.stockii.invest.api;

import org.apache.log4j.Logger;

import com.stockii.invest.api.response.StockBasicInfoResponse;
import com.stockii.invest.service.StockBasicInfo;


public class StockApiResponseHelper implements StockResponseGenerator{
    public final Logger s_logger = Logger.getLogger(StockApiResponseHelper.class);

	@Override
	public StockBasicInfoResponse createStockReponse(StockBasicInfo stock) {
		StockBasicInfoResponse stockResponse  = new StockBasicInfoResponse();
		stockResponse.setStockId(stock.getStockId());
		stockResponse.setStockName(stock.getStockName());
		stockResponse.setListDate(stock.getListDate());
		
		stockResponse.setObjectName("stockbasicinfo");
		
		return stockResponse;
	}

}
