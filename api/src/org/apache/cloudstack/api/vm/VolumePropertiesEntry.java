package org.apache.cloudstack.api.vm;

public class VolumePropertiesEntry {

	String path;
	String folder;
	Long size;
	Integer unitNumber;
	Boolean isShared;
	Boolean isBareLun;
	String compatibilityMode;
	String lunUuid;
	
	public VolumePropertiesEntry(){
		
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Integer getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(Integer unitNumber) {
		this.unitNumber = unitNumber;
	}
	
	public Boolean getIsShared() {
		return isShared;
	}

	public void setIsShared(Boolean isShared) {
		this.isShared = isShared;
	}

	public Boolean getIsBareLun() {
		return isBareLun;
	}

	public void setIsBareLun(Boolean isBareLun) {
		this.isBareLun = isBareLun;
	}

	public String getCompatibilityMode() {
		return compatibilityMode;
	}

	public void setCompatibilityMode(String compatibilityMode) {
		this.compatibilityMode = compatibilityMode;
	}

	public String getLunUuid() {
		return lunUuid;
	}

	public void setLunUuid(String lunUuid) {
		this.lunUuid = lunUuid;
	}
	
}
