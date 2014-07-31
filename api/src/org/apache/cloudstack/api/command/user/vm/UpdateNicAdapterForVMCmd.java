package org.apache.cloudstack.api.command.user.vm;

import org.apache.cloudstack.api.APICommand;
import org.apache.cloudstack.api.ApiConstants;
import org.apache.cloudstack.api.ApiErrorCode;
import org.apache.cloudstack.api.BaseCmd;
import org.apache.cloudstack.api.Parameter;
import org.apache.cloudstack.api.ServerApiException;
import org.apache.cloudstack.api.BaseCmd.CommandType;
import org.apache.cloudstack.api.response.GuestOSResponse;
import org.apache.cloudstack.api.response.SuccessResponse;
import org.apache.cloudstack.api.response.UserVmResponse;
import org.apache.log4j.Logger;

import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.user.Account;
import com.cloud.user.UserContext;
import com.cloud.uservm.UserVm;

@APICommand(name = "updateNicAdapterForVM", description="Update nic adapter for vm", responseObject = SuccessResponse.class)
public class UpdateNicAdapterForVMCmd extends BaseCmd {
    public static final Logger s_logger = Logger.getLogger(UpdateNicAdapterForVMCmd.class.getName());
    private static final String s_name = "updatenicadapterforvmresponse";

    /////////////////////////////////////////////////////
    //////////////// API parameters /////////////////////
    /////////////////////////////////////////////////////

    @Parameter(name=ApiConstants.ID, type=CommandType.UUID, entityType=UserVmResponse.class,
            required=true, description="The ID of the virtual machine")
    private Long id;

    @Parameter(name="nicadapter", type=CommandType.STRING, required=true, description="the nicadapter for vmware vm.")
    private String nicAdapter;

    /////////////////////////////////////////////////////
    /////////////////// Accessors ///////////////////////
    /////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public String getNicAdapter() {
		return nicAdapter;
	}
    
    /////////////////////////////////////////////////////
    /////////////// API Implementation///////////////////
    /////////////////////////////////////////////////////

    @Override
    public String getCommandName() {
        return s_name;
    }
    
    public static String getResultObjectName() {
        return "updatenicadapterforvm";
    }

    @Override
    public long getEntityOwnerId() {
       /* UserVm userVm = _entityMgr.findById(UserVm.class, getId());
        if (userVm != null) {
            return userVm.getAccountId();
        }*/

        return Account.ACCOUNT_ID_SYSTEM; // no account info given, parent this command to SYSTEM so ERROR events are tracked
    }

    @Override
    public void execute() throws ResourceUnavailableException,
            InsufficientCapacityException, ServerApiException {/*
        UserContext.current().setEventDetails("Vm Id: "+getId());
        boolean result = _userVmService.updateNicAdapterForVM(this.id, this.nicAdapter);
        if (result) {
            SuccessResponse response = new SuccessResponse(getCommandName());
            this.setResponseObject(response);
        } else {
            throw new ServerApiException(ApiErrorCode.INTERNAL_ERROR, "Failed to update nic adapter for vm");
        }
    */}
}
