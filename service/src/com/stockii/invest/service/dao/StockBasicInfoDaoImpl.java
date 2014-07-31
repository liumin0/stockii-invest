package com.stockii.invest.service.dao;

import java.util.Date;

import javax.ejb.Local;

import org.apache.log4j.Logger;

import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.Transaction;
import com.stockii.invest.service.StockBasicInfo;
import com.stockii.invest.service.StockBasicInfoVO;


@Local(value={StockBasicInfoDao.class})
public class StockBasicInfoDaoImpl extends GenericDaoBase<StockBasicInfoVO, Long> implements StockBasicInfoDao{
	public final Logger s_logger = Logger.getLogger(StockBasicInfoDaoImpl.class);

	@Override
	public StockBasicInfo createStock(String stockId, String stockName, Date listDate) {
		Transaction txn = Transaction.currentTxn();
		txn.start();

		StockBasicInfoVO stock = new StockBasicInfoVO(stockId, stockName, listDate);
		persist(stock);
		
		txn.commit();
		
		return stock;
	}
}

