package com.stockii.invest.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="stock_basic_info")
public class StockBasicInfoVO implements StockBasicInfo {

	@Column(name="stock_id")
    private String stockId;
    
    @Column(name="stock_name")
	private String stockName;

    @Column(name="list_date")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date listDate;
	
	public StockBasicInfoVO() {
	}
	
	public StockBasicInfoVO(String stockId, String stockName, Date listDate){
		this.stockId = stockId;
		this.stockName = stockName;
		this.listDate = listDate;
	}

	@Override
	public long getId() {
		return 0;
	}
	
	@Override
	public String getStockName() {
		return this.stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Override
	public Date getListDate() {
		return this.listDate;
	}

	public void setListDate(Date listDate) {
		this.listDate = listDate;
	}
	
	@Override
	public String getStockId() {
		return this.stockId;
	}
	
    public void setStockId(String stockId) {
		this.stockId = stockId;
	}
}
