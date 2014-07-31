package com.stockii.invest.api.commands;

import java.util.Date;

import javax.inject.Inject;

import org.apache.cloudstack.api.APICommand;
import org.apache.cloudstack.api.ApiErrorCode;
import org.apache.cloudstack.api.BaseCmd;
import org.apache.cloudstack.api.Parameter;
import org.apache.cloudstack.api.ServerApiException;
import org.apache.log4j.Logger;

import com.stockii.invest.api.StockApiResponseHelper;
import com.stockii.invest.api.StockConstants;
import com.stockii.invest.api.StockResponseGenerator;
import com.stockii.invest.api.response.StockBasicInfoResponse;
import com.stockii.invest.service.StockBasicInfo;
import com.stockii.invest.service.manager.StockInvestService;

@APICommand(name = "createStockBasicInfo", responseObject=StockBasicInfoResponse.class, description="Create stock with info.")
public class CreateStockBasicInfoCmd extends BaseCmd{
    public static final Logger s_logger = Logger.getLogger(CreateStockBasicInfoCmd.class.getName());
    private static final String s_name = "createstockresponse";
    
    @Inject 
    public StockInvestService _stockService;

    /////////////////////////////////////////////////////
    //////////////// API parameters /////////////////////
    /////////////////////////////////////////////////////
    
    @Parameter(name=StockConstants.STOCK_ID, type=CommandType.STRING, required=true, description="the id of the stock")
    private String stockId;
    
    @Parameter(name=StockConstants.STOCK_NAME, type=CommandType.STRING, required=true, description="the name of the stock")
    private String stockName;
    
    @Parameter(name=StockConstants.LIST_DATE, type=CommandType.DATE, required=true, description="the date of the stock created" +
    		" (including) this date (use format \"yyyy-MM-dd\" or the new format \"yyyy-MM-ddThh:mm:ss\")")
    private Date listDate;
    
    
    /////////////////////////////////////////////////////
    /////////////////// Accessors ///////////////////////
    /////////////////////////////////////////////////////
    
    public String getStockId() {
    	return stockId;
    }
    
    public String getStockName() {
    	return stockName;
    }
    
    public Date getListDate() {
    	return listDate;
    }

    /////////////////////////////////////////////////////
    /////////////// API Implementation///////////////////
    /////////////////////////////////////////////////////
    
    @Override
    public String getCommandName() {
    	return s_name;
    }

	@Override
	public void execute() {
		StockResponseGenerator stockResponseGenerator = new StockApiResponseHelper();
		StockBasicInfo result = _stockService.createBasicStock(this);
		if (result != null) {
			StockBasicInfoResponse reponse = stockResponseGenerator.createStockReponse(result);
			reponse.setResponseName(getCommandName());
			this.setResponseObject(reponse);
		} else {
			throw new ServerApiException(ApiErrorCode.INTERNAL_ERROR, "Failed to create basic stock info.");
		}
	}

	@Override
	public long getEntityOwnerId() {
		return 0; 
	}
}
