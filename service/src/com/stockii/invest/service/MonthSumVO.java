package com.stockii.invest.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="stock_basic_info")
public class MonthSumVO implements MonthSum {

	@Column(name="stock_id")
    private String stockId;

    @Column(name="created")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date created;
	
	@Column(name="one_month_sum_growth")
    private Double oneMonthSumGrowth;
	
	@Column(name="one_month_sum_turn")
    private Double oneMonthSumTurn;
	
	@Column(name="one_month_sum_amp")
    private Double oneMonthSumAmp;
	
	@Column(name="one_month_sum_total")
    private Long oneMonthSumTotal;
	
	@Column(name="one_month_sum_vol")
    private Double oneMonthSumVol;
	
	public MonthSumVO() {
	}

	@Override
	public long getId() {
		return 0;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	@Override
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public Double getOneMonthSumGrowth() {
		return oneMonthSumGrowth;
	}

	public void setOneMonthSumGrowth(Double oneMonthSumGrowth) {
		this.oneMonthSumGrowth = oneMonthSumGrowth;
	}

	@Override
	public Double getOneMonthSumTurn() {
		return oneMonthSumTurn;
	}

	public void setOneMonthSumTurn(Double oneMonthSumTurn) {
		this.oneMonthSumTurn = oneMonthSumTurn;
	}

	@Override
	public Double getOneMonthSumAmp() {
		return oneMonthSumAmp;
	}

	public void setOneMonthSumAmp(Double oneMonthSumAmp) {
		this.oneMonthSumAmp = oneMonthSumAmp;
	}

	@Override
	public Long getOneMonthSumTotal() {
		return oneMonthSumTotal;
	}

	public void setOneMonthSumTotal(Long oneMonthSumTotal) {
		this.oneMonthSumTotal = oneMonthSumTotal;
	}

	@Override
	public Double getOneMonthSumVol() {
		return oneMonthSumVol;
	}

	public void setOneMonthSumVol(Double oneMonthSumVol) {
		this.oneMonthSumVol = oneMonthSumVol;
	}
}
