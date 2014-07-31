package com.stockii.invest.api.commands;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.cloudstack.api.APICommand;
import org.apache.cloudstack.api.BaseListCmd;
import org.apache.cloudstack.api.Parameter;
import org.apache.cloudstack.api.response.ListResponse;
import org.apache.log4j.Logger;

import com.stockii.invest.api.StockApiResponseHelper;
import com.stockii.invest.api.StockConstants;
import com.stockii.invest.api.StockResponseGenerator;
import com.stockii.invest.api.response.StockBasicInfoResponse;
import com.stockii.invest.service.StockBasicInfoVO;
import com.stockii.invest.service.manager.StockInvestService;

@APICommand(name = "listStockBasicInfo", description = "list stock basic info.", responseObject = StockBasicInfoResponse.class)
public class ListStockBasicInfoCmd extends BaseListCmd {
	public static final Logger s_logger = Logger.getLogger(ListStockBasicInfoCmd.class.getName());
	private static final String s_name = "liststockbasicinforesponse";
	
    @Inject
    StockInvestService _stockService;
    
    @Parameter(name = StockConstants.STOCK_ID, type=CommandType.STRING, description = "the ID of stock")
    private String stockId;
    
    @Parameter(name = StockConstants.STOCK_NAME, type=CommandType.STRING, description="the name of stock")
    private String stockName;

	public String getStockId() {
		return stockId;
	}

	public String getStockName() {
		return stockName;
	}

	@Override
	public void execute() {
		StockResponseGenerator stockResponseGenerator = new StockApiResponseHelper();
        List<StockBasicInfoVO> result = _stockService.searchForBasicStocks(this);
        ListResponse<StockBasicInfoResponse> response = new ListResponse<StockBasicInfoResponse>();
        
        List<StockBasicInfoResponse> stockResponses = new ArrayList<StockBasicInfoResponse>();
        if(result != null){
        	for (StockBasicInfoVO stock : result) {
        		StockBasicInfoResponse stockResponse =  stockResponseGenerator.createStockReponse(stock);
        		stockResponses.add(stockResponse);
            }
        }
        
        response.setResponses(stockResponses);
        response.setResponseName(getCommandName());
        this.setResponseObject(response);
	}

	@Override
	public String getCommandName() {
		return s_name;
	}
}
