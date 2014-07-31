package org.apache.cloudstack.api.vm;

import java.util.Map;

public interface VmProperties {
//	public String getInstanceName();
	public String getCpuNumber();
	public String getCpuSpeed();
	public String getMemory();
	public String getIpAddress();
	public String getHostName();
	public String getRootVolumeName();
	public String getRootVolumeFolder();
	public String getRootVolumePath();
	public Long getRootVolumeSize();
	public Map<String, VolumePropertiesEntry> getDiskVolumeMap();
	public Map<String, NicPropertiesEntry> getNicMap();
	public String getPowerState();
	public String getGuestOSId();
	public String getGuestOSDescription();
}
