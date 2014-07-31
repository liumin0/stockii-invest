package com.cloud.agent.api;

import com.cloud.agent.api.to.StorageFilerTO;

public class MigrateVmwareWithStorageCommand extends Command {
	String vmName;
    String destIp;
    StorageFilerTO destStorage;
    
    protected MigrateVmwareWithStorageCommand() {
    }

    public MigrateVmwareWithStorageCommand(String vmName, String destIp, StorageFilerTO destStorage) {
        this.vmName = vmName;
        this.destIp = destIp;
        this.destStorage = destStorage;
    }
    
	public String getVmName() {
		return vmName;
	}

	public String getDestIp() {
		return destIp;
	}

	public StorageFilerTO getDestStorage() {
		return destStorage;
	}

	@Override
	public boolean executeInSequence() {
		return false;
	}

}
