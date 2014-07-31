package org.apache.cloudstack.api.vm;

import java.util.List;

public class NicPropertiesEntry {

	List<String> ipv4;
	List<String> ipv6;
	String macAddress;
	String vlanId;
	
	public NicPropertiesEntry(){
		
	}

	public List<String> getIpv4() {
		return ipv4;
	}

	public void setIpv4(List<String> ipv4) {
		this.ipv4 = ipv4;
	}

	public List<String> getIpv6() {
		return ipv6;
	}

	public void setIpv6(List<String> ipv6) {
		this.ipv6 = ipv6;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getVlanId() {
		return vlanId;
	}

	public void setVlanId(String vlanId) {
		this.vlanId = vlanId;
	}

}
