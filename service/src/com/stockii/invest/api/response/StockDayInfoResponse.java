package com.stockii.invest.api.response;

import java.util.Date;

import org.apache.cloudstack.api.BaseResponse;

import com.cloud.serializer.Param;
import com.google.gson.annotations.SerializedName;
import com.stockii.invest.api.StockConstants;

public class StockDayInfoResponse extends BaseResponse {

    @SerializedName(StockConstants.STOCK_ID) @Param(description="the id of the stock")
    private String stockId;
    
    @SerializedName(StockConstants.STOCK_NAME) @Param(description="the name of the stock")
    private String stockName;
    
    @SerializedName(StockConstants.LIST_DATE) @Param(description="the date and time the stock was created")
    private Date listDate;

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Date getListDate() {
		return listDate;
	}

	public void setListDate(Date listDate) {
		this.listDate = listDate;
	}
}
