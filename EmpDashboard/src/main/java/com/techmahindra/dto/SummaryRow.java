package com.techmahindra.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SummaryRow {

	String columnRowName;
	int totalOffshore;
	int totalOnsite;
	int totalAllocated;
	int unbilledOffshore;
	int unbilledOnsite;
	int doNOTBILL;
	int totalUnbilled;
	int billedOffshore;
	int billedOnsite;
	int totalBilled;
	
	
	public String getColumnRowName() {
		return columnRowName;
	}
	public void setColumnRowName(String columnRowName) {
		this.columnRowName = columnRowName;
	}
	public int getTotalOffshore() {
		return totalOffshore;
	}
	public void setTotalOffshore(int totalOffshore) {
		this.totalOffshore = totalOffshore;
	}
	public int getTotalOnsite() {
		return totalOnsite;
	}
	public void setTotalOnsite(int totalOnsite) {
		this.totalOnsite = totalOnsite;
	}
	public int getTotalAllocated() {
		return totalAllocated;
	}
	public void setTotalAllocated(int totalAllocated) {
		this.totalAllocated = totalAllocated;
	}
	public int getUnbilledOffshore() {
		return unbilledOffshore;
	}
	public void setUnbilledOffshore(int unbilledOffshore) {
		this.unbilledOffshore = unbilledOffshore;
	}
	public int getUnbilledOnsite() {
		return unbilledOnsite;
	}
	public void setUnbilledOnsite(int unbilledOnsite) {
		this.unbilledOnsite = unbilledOnsite;
	}
	public int getDoNOTBILL() {
		return doNOTBILL;
	}
	public void setDoNOTBILL(int doNOTBILL) {
		this.doNOTBILL = doNOTBILL;
	}
	public int getTotalUnbilled() {
		return totalUnbilled;
	}
	public void setTotalUnbilled(int totalUnbilled) {
		this.totalUnbilled = totalUnbilled;
	}
	public int getBilledOffshore() {
		return billedOffshore;
	}
	public void setBilledOffshore(int billedOffshore) {
		this.billedOffshore = billedOffshore;
	}
	public int getBilledOnsite() {
		return billedOnsite;
	}
	public void setBilledOnsite(int billedOnsite) {
		this.billedOnsite = billedOnsite;
	}
	public int getTotalBilled() {
		return totalBilled;
	}
	public void setTotalBilled(int totalBilled) {
		this.totalBilled = totalBilled;
	}
	
	
}
