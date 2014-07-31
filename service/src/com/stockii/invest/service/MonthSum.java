package com.stockii.invest.service;

import java.util.Date;

import org.apache.cloudstack.api.InternalIdentity;

public interface MonthSum extends InternalIdentity {
	public String getStockId();
	public Date getCreated();
	public Double getOneMonthSumGrowth();
	public Double getOneMonthSumTurn();
	public Double getOneMonthSumAmp();
	public Long getOneMonthSumTotal();
	public Double getOneMonthSumVol();
}
