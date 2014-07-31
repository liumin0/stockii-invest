package com.stockii.invest.service;

import java.util.Date;
import org.apache.cloudstack.api.InternalIdentity;

public interface StockBasicInfo extends InternalIdentity {
	public String getStockId();
	public String getStockName();
	public Date getListDate();
}
