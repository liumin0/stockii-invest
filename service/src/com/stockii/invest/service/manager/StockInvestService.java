package com.stockii.invest.service.manager;

import java.util.List;

import com.cloud.utils.component.PluggableService;
import com.stockii.invest.api.commands.CreateStockBasicInfoCmd;
import com.stockii.invest.api.commands.GetStockDayInfoCmd;
import com.stockii.invest.api.commands.ListStockBasicInfoCmd;
import com.stockii.invest.service.StockBasicInfo;
import com.stockii.invest.service.StockBasicInfoVO;

public interface StockInvestService extends PluggableService {
	StockBasicInfo createBasicStock(CreateStockBasicInfoCmd cmd);
	List<StockBasicInfoVO> searchForBasicStocks(ListStockBasicInfoCmd listStockCmd);
	List<StockBasicInfoVO> searchForBasicDayStocks(GetStockDayInfoCmd dayStockCmd);
}
