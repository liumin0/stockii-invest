package com.cloud.vm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.cloudstack.api.vm.VmPropertiesEntry;

import com.cloud.offering.ServiceOffering;
import com.cloud.utils.component.ManagerBase;

public class MockImportVMManagerImpl extends ManagerBase implements ImportVMService{

	@Override
	public List<Class<?>> getCommands() {
		return new ArrayList<Class<?>>();
	}

	@Override
	public Map<String, VmPropertiesEntry> getResourceClusterVMs(Long clusterId) {
		return null;
	}

	@Override
	public ServiceOffering DealwithServiceOffering(Long cpuNumber,
			Long cpuSpeed, Long memory) {
		return null;
	}

	@Override
	public Map<String, VmPropertiesEntry> getUnmanagementVM(Long clusterId) {
		return null;
	}

	@Override
	public Map<String, VmPropertiesEntry> getAgentVmDetails(
			String instanceName, Long clusterId) {
		return null;
	}

	@Override
	public boolean resetAgentVMName(String instanceName, String string,
			Long clusterId) {
		return false;
	}

	@Override
	public boolean configUnmanagedVM(String vmName, String vncPassword,
			long clusterId) {
		return false;
	}

	@Override
	public void syncDisk(VmPropertiesEntry vmDetails, long vmId,
			String hostName, long accountId, long domainId, long podId,
			long zoneId) {
	}

	@Override
	public boolean isAchieved() {
		return false;
	}

}
