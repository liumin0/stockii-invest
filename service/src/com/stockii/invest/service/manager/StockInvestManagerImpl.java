package com.stockii.invest.service.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.cloud.exception.InvalidParameterValueException;
import com.cloud.utils.component.ManagerBase;
import com.cloud.utils.db.SearchBuilder;
import com.cloud.utils.db.SearchCriteria;
import com.stockii.invest.api.commands.CreateStockBasicInfoCmd;
import com.stockii.invest.api.commands.GetStockDayInfoCmd;
import com.stockii.invest.api.commands.ListStockBasicInfoCmd;
import com.stockii.invest.service.StockBasicInfo;
import com.stockii.invest.service.StockBasicInfoVO;
import com.stockii.invest.service.dao.StockBasicInfoDao;

@Local(value = { StockInvestManager.class, StockInvestService.class })
public class StockInvestManagerImpl extends ManagerBase implements StockInvestService,StockInvestManager {
	public static final Logger s_logger = Logger.getLogger(StockInvestManagerImpl.class.getName());
	
	@Inject
	private StockBasicInfoDao _stockDao;
	
	@Override
	public List<Class<?>> getCommands() {
		List<Class<?>> cmdList = new ArrayList<Class<?>>();
		cmdList.add(CreateStockBasicInfoCmd.class);
		cmdList.add(ListStockBasicInfoCmd.class);
		cmdList.add(GetStockDayInfoCmd.class);
		return cmdList;
	}

	@Override
	public StockBasicInfo createBasicStock(CreateStockBasicInfoCmd cmd) {
		if (cmd.getStockId() == null) {
			throw new InvalidParameterValueException("Stock id is empty.");
		}
		
		if (cmd.getStockName() == null) {
			throw new InvalidParameterValueException("Stock name is empty.");
		}

		if (cmd.getListDate() == null) {
			throw new InvalidParameterValueException("Stock date is empty.");
		}
		
		StockBasicInfo stock = _stockDao.createStock(cmd.getStockId(), cmd.getStockName(), cmd.getListDate());

		return stock;
	}

	@Override
	public List<StockBasicInfoVO> searchForBasicStocks(ListStockBasicInfoCmd listStockCmd) {
		SearchBuilder<StockBasicInfoVO> stockSearch = _stockDao.createSearchBuilder();
		stockSearch.and("id", stockSearch.entity().getStockId(), SearchCriteria.Op.EQ);
		stockSearch.and("name", stockSearch.entity().getStockName(),SearchCriteria.Op.LIKE);

		String stockId = listStockCmd.getStockId();
		String stockName = listStockCmd.getStockName();

		SearchCriteria<StockBasicInfoVO> sc = stockSearch.create();
		if (stockId != null) {
			sc.setParameters("id", stockId);
		}
		if (stockName != null) {
			sc.setParameters("name", "%" + stockName + "%");
		}
		return _stockDao.search(sc, null);
	}
	
	@Override
	public List<StockBasicInfoVO> searchForBasicDayStocks(GetStockDayInfoCmd dayStockCmd) {
		SearchBuilder<StockBasicInfoVO> stockSearch = _stockDao.createSearchBuilder();
		stockSearch.and("id", stockSearch.entity().getStockId(), SearchCriteria.Op.EQ);
		stockSearch.and("name", stockSearch.entity().getStockName(),SearchCriteria.Op.LIKE);

		String stockId = dayStockCmd.getStockId();
		String stockName = dayStockCmd.getStockName();

		SearchCriteria<StockBasicInfoVO> sc = stockSearch.create();
		if (stockId != null) {
			sc.setParameters("id", stockId);
		}
		if (stockName != null) {
			sc.setParameters("name", "%" + stockName + "%");
		}
		return _stockDao.search(sc, null);
	}
}
