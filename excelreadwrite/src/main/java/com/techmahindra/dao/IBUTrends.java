package com.techmahindra.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IBU_TRENDS")
public class IBUTrends {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int IBU_TRENDS_ID;
	
	@Column(name = "IT_DATE") private Timestamp IT_DATE;
	@Column(name = "DELIVERY_TOTAL") private int DELIVERY_TOTAL;
	@Column(name = "NON_DELIVERY_SUB_TOTAL") private int NON_DELIVERY_SUB_TOTAL;
	@Column(name = "IBU_BUFFER") private int IBU_BUFFER;
	@Column(name = "TOTAL_UNBILLED") private int TOTAL_UNBILLED;
	@Column(name = "TOTAL_BILLED") private int TOTAL_BILLED;
	@Column(name = "UNBILLED_DELIVERY") private int UNBILLED_DELIVERY;
	@Column(name = "IBU_TOTAL") private int IBU_TOTAL;
	
	public int getIBU_TRENDS_ID() {
		return IBU_TRENDS_ID;
	}
	public void setIBU_TRENDS_ID(int iBU_TRENDS_ID) {
		IBU_TRENDS_ID = iBU_TRENDS_ID;
	}
	public Timestamp getSTATUS() {
		return IT_DATE;
	}
	public void setSTATUS(Timestamp sTATUS) {
		IT_DATE = sTATUS;
	}
	public int getDELIVERY_TOTAL() {
		return DELIVERY_TOTAL;
	}
	public void setDELIVERY_TOTAL(int dELIVERY_TOTAL) {
		DELIVERY_TOTAL = dELIVERY_TOTAL;
	}
	public int getNON_DELIVERY_SUB_TOTAL() {
		return NON_DELIVERY_SUB_TOTAL;
	}
	public void setNON_DELIVERY_SUB_TOTAL(int nON_DELIVERY_SUB_TOTAL) {
		NON_DELIVERY_SUB_TOTAL = nON_DELIVERY_SUB_TOTAL;
	}
	public int getIBU_BUFFER() {
		return IBU_BUFFER;
	}
	public void setIBU_BUFFER(int iBU_BUFFER) {
		IBU_BUFFER = iBU_BUFFER;
	}
	public int getTOTAL_UNBILLED() {
		return TOTAL_UNBILLED;
	}
	public void setTOTAL_UNBILLED(int tOTAL_UNBILLED) {
		TOTAL_UNBILLED = tOTAL_UNBILLED;
	}
	public int getTOTAL_BILLED() {
		return TOTAL_BILLED;
	}
	public void setTOTAL_BILLED(int tOTAL_BILLED) {
		TOTAL_BILLED = tOTAL_BILLED;
	}
	public int getUNBILLED_DELIVERY() {
		return UNBILLED_DELIVERY;
	}
	public void setUNBILLED_DELIVERY(int uNBILLED_DELIVERY) {
		UNBILLED_DELIVERY = uNBILLED_DELIVERY;
	}
	public int getIBU_TOTAL() {
		return IBU_TOTAL;
	}
	public void setIBU_TOTAL(int iBU_TOTAL) {
		IBU_TOTAL = iBU_TOTAL;
	}
	
	
}
