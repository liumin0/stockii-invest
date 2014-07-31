package org.apache.cloudstack.api.vm;

import java.util.HashMap;
import java.util.Map;

public class VmPropertiesEntry implements VmProperties {

//	String instanceName;
	String cpuNumber;
	String cpuSpeed;
	String memory;
	String ipAddress;
	String hostName;
	String rootVolumeName;
	String rootVolumeFolder;
	String rootVolumePath;
	Long rootVolumeSize;
	Map<String, VolumePropertiesEntry> diskVolumeMap = new HashMap<String, VolumePropertiesEntry>(); //only have disk volume,but I want put all volumes
	Map<String, NicPropertiesEntry> nicMap = new HashMap<String, NicPropertiesEntry>(); //all nic ips.[key,value]:key is deviceConfigId-->device(eg:4000-->0)
	String powerState;
	String guestOSId;
	String guestOSDescription;
	String internalName;
	
	public String getGuestOSDescription() {
		return guestOSDescription;
	}

	public void setGuestOSDescription(String guestOSDescription) {
		this.guestOSDescription = guestOSDescription;
	}

	public VmPropertiesEntry(){
		
	}

	public String getCpuNumber() {
		return cpuNumber;
	}

	public void setCpuNumber(String cpuNumber) {
		this.cpuNumber = cpuNumber;
	}

	public String getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(String cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getRootVolumeName() {
		return rootVolumeName;
	}

	public void setRootVolumeName(String rootVolumeName) {
		this.rootVolumeName = rootVolumeName;
	}

	public String getRootVolumeFolder() {
		return rootVolumeFolder;
	}

	public void setRootVolumeFolder(String rootVolumeFolder) {
		this.rootVolumeFolder = rootVolumeFolder;
	}

	public String getRootVolumePath() {
		return rootVolumePath;
	}

	public void setRootVolumePath(String rootVolumePath) {
		this.rootVolumePath = rootVolumePath;
	}

	public String getPowerState() {
		return powerState;
	}

	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}

	public Map<String, VolumePropertiesEntry> getDiskVolumeMap() {
		return diskVolumeMap;
	}

	public void setDiskVolumeMap(Map<String, VolumePropertiesEntry> diskVolumeMap) {
		this.diskVolumeMap = diskVolumeMap;
	}

	public Long getRootVolumeSize() {
		return rootVolumeSize;
	}

	public void setRootVolumeSize(Long rootVolumeSize) {
		this.rootVolumeSize = rootVolumeSize;
	}

	public String getGuestOSId() {
		return guestOSId;
	}

	public void setGuestOSId(String guestOSId) {
		this.guestOSId = guestOSId;
	}

	public Map<String, NicPropertiesEntry> getNicMap() {
		return nicMap;
	}

	public void setNicMap(Map<String, NicPropertiesEntry> nicMap) {
		this.nicMap = nicMap;
	}

	public String getInternalName() {
		return internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

}
