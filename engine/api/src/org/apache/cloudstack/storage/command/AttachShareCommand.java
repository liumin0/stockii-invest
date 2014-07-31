package org.apache.cloudstack.storage.command;

import com.cloud.agent.api.to.DiskTO;

public class AttachShareCommand extends AttachCommand {
	private boolean isShared;
	
	public AttachShareCommand(DiskTO disk, String vmName, boolean isShared) {
        super(disk, vmName);
        this.isShared = isShared;
    }
	
	public boolean isShared() {
        return isShared;
    }

	public void setIsShared(boolean isShared) {
        this.isShared = isShared;
    }
}
