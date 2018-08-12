package com.techmahindra.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESOURCE_TRACKER")
public class ResourceTracker {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int RESOURCE_TRACKER_ID;
	
	@Column(name = "STATUS") private String STATUS;
	@Column(name = "EMPLOYEE_ID") private String EMPLOYEE_ID;
	@Column(name = "EMPLOYEE_NAME") private String EMPLOYEE_NAME;
	@Column(name = "BAND") private String BAND;
	@Column(name = "PROJECT_DESCRIPTION") private String PROJECT_DESCRIPTION;
	@Column(name = "PROGRAM_MANAGER_NAME") private String PROGRAM_MANAGER_NAME;
	@Column(name = "DATE") private Timestamp DATE;
	
	public int getRESOURCE_TRACKER_ID() {
		return RESOURCE_TRACKER_ID;
	}
	public void setRESOURCE_TRACKER_ID(int rESOURCE_TRACKER_ID) {
		RESOURCE_TRACKER_ID = rESOURCE_TRACKER_ID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(String eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}
	public String getEMPLOYEE_NAME() {
		return EMPLOYEE_NAME;
	}
	public void setEMPLOYEE_NAME(String eMPLOYEE_NAME) {
		EMPLOYEE_NAME = eMPLOYEE_NAME;
	}
	public String getBAND() {
		return BAND;
	}
	public void setBAND(String bAND) {
		BAND = bAND;
	}
	public String getPROJECT_DESCRIPTION() {
		return PROJECT_DESCRIPTION;
	}
	public void setPROJECT_DESCRIPTION(String pROJECT_DESCRIPTION) {
		PROJECT_DESCRIPTION = pROJECT_DESCRIPTION;
	}
	public String getPROGRAM_MANAGER_NAME() {
		return PROGRAM_MANAGER_NAME;
	}
	public void setPROGRAM_MANAGER_NAME(String pROGRAM_MANAGER_NAME) {
		PROGRAM_MANAGER_NAME = pROGRAM_MANAGER_NAME;
	}
	public Timestamp getDATE() {
		return DATE;
	}
	public void setDATE(Timestamp dATE) {
		DATE = dATE;
	}
	
	
	
}
