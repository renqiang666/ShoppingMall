package com.hotelsystem.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ViManagerLoginBean {
	private int vmId;
	private String vmName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date vmOnTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date vmOffTime;
	private String vmStatus;
	public int getVmId() {
		return vmId;
	}
	public void setVmId(int vmId) {
		this.vmId = vmId;
	}
	public String getVmName() {
		return vmName;
	}
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}
	public Date getVmOnTime() {
		return vmOnTime;
	}
	public void setVmOnTime(Date vmOnTime) {
		this.vmOnTime = vmOnTime;
	}
	public Date getVmOffTime() {
		return vmOffTime;
	}
	public void setVmOffTime(Date vmOffTime) {
		this.vmOffTime = vmOffTime;
	}
	
	public String getVmStatus() {
		return vmStatus;
	}
	public void setVmStatus(String vmStatus) {
		this.vmStatus = vmStatus;
	}
	@Override
	public String toString() {
		return "ViManagerLoginBean [vmId=" + vmId + ", vmName=" + vmName + ", vmOnTime=" + vmOnTime + ", vmOffTime="
				+ vmOffTime + ", vmStatus=" + vmStatus + "]";
	}
	
	
}
