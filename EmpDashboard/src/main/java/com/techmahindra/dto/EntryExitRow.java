package com.techmahindra.dto;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EntryExitRow {

	Date date;
	String status;
	String employeeID;
	String employeeName;
	String band;
	String projectDescription;
	String programManagerName;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getProgramManagerName() {
		return programManagerName;
	}
	public void setProgramManagerName(String programManagerName) {
		this.programManagerName = programManagerName;
	}
	
	
	@Override
	public String toString() {
		return "EntryExitRow [date=" + date + ", status=" + status + ", employeeID=" + employeeID + ", employeeName="
				+ employeeName + ", band=" + band + ", projectDescription=" + projectDescription
				+ ", programManagerName=" + programManagerName + "]";
	}
	
	
	
}
