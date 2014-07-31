package com.cloud.vm;

import java.util.Map;

import org.apache.cloudstack.api.vm.VmPropertiesEntry;

import com.cloud.offering.ServiceOffering;
import com.cloud.utils.component.PluggableService;

public interface ImportVMService extends PluggableService {

	Map<String, VmPropertiesEntry> getResourceClusterVMs(Long clusterId);
	
	ServiceOffering DealwithServiceOffering(Long cpuNumber, Long cpuSpeed, Long memory);
	
	Map<String, VmPropertiesEntry> getUnmanagementVM(Long clusterId);

	Map<String, VmPropertiesEntry> getAgentVmDetails(String instanceName, Long clusterId);

	boolean resetAgentVMName(String instanceName, String string, Long clusterId);
	
	boolean configUnmanagedVM(String vmName, String vncPassword, long clusterId);
	
	void syncDisk(VmPropertiesEntry vmDetails, long vmId, String hostName, long accountId, long domainId, long podId, long zoneId);
	
	boolean isAchieved();
}
