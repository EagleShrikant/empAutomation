package com.techmahindra.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UNBILLED_DATA")
public class UnbilledData {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int UNBILLED_ID;
	
	@Column(name = "PROGRAM_MANAGER") private String PROGRAM_MANAGER;
	@Column(name = "CUSTOMER") private String CUSTOMER;
	@Column(name = "PROJECT") private String PROJECT;
	@Column(name = "ONSITE_OFFSHORE") private String ONSITE_OFFSHORE;
	@Column(name = "IBU") private String IBU;
	@Column(name = "EMPLID") private String EMPLID;
	@Column(name = "EMP_NAME") private String EMP_NAME;
	@Column(name = "SUPERVISOR_NAME") private String SUPERVISOR_NAME;
	@Column(name = "PRIMAERY_SKILL_CATEGARY_1") private String PRIMAERY_SKILL_CATEGARY_1;
	@Column(name = "PRIMAERY_SKILL_CATEGARY_2") private String PRIMAERY_SKILL_CATEGARY_2;
	@Column(name = "COMMENTS") private String COMMENTS;
	@Column(name = "ACCOUNT") private String ACCOUNT;
	@Column(name = "BILLING_START_DATE") private Timestamp BILLING_START_DATE;
	@Column(name = "CATEGARY") private String CATEGARY;
	@Column(name = "SUB_CATEGARY") private String SUB_CATEGARY;
	@Column(name = "ACTION_EMP_ID") private String ACTION_EMP_ID;
	@Column(name = "ACTION_EMP_NAME") private String ACTION_EMP_NAME;
	@Column(name = "ACTION_EMP_EMAIL") private String ACTION_EMP_EMAIL;
	
	public int getUNBILLED_ID() {
		return UNBILLED_ID;
	}
	public void setUNBILLED_ID(int uNBILLED_ID) {
		UNBILLED_ID = uNBILLED_ID;
	}
	public String getPROGRAM_MANAGER() {
		return PROGRAM_MANAGER;
	}
	public void setPROGRAM_MANAGER(String pROGRAM_MANAGER) {
		PROGRAM_MANAGER = pROGRAM_MANAGER;
	}
	public String getCUSTOMER() {
		return CUSTOMER;
	}
	public void setCUSTOMER(String cUSTOMER) {
		CUSTOMER = cUSTOMER;
	}
	public String getPROJECT() {
		return PROJECT;
	}
	public void setPROJECT(String pROJECT) {
		PROJECT = pROJECT;
	}
	public String getONSITE_OFFSHORE() {
		return ONSITE_OFFSHORE;
	}
	public void setONSITE_OFFSHORE(String oNSITE_OFFSHORE) {
		ONSITE_OFFSHORE = oNSITE_OFFSHORE;
	}
	public String getIBU() {
		return IBU;
	}
	public void setIBU(String iBU) {
		IBU = iBU;
	}
	public String getEMPLID() {
		return EMPLID;
	}
	public void setEMPLID(String eMPLID) {
		EMPLID = eMPLID;
	}
	public String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}
	public String getSUPERVISOR_NAME() {
		return SUPERVISOR_NAME;
	}
	public void setSUPERVISOR_NAME(String sUPERVISOR_NAME) {
		SUPERVISOR_NAME = sUPERVISOR_NAME;
	}
	public String getPRIMAERY_SKILL_CATEGARY_1() {
		return PRIMAERY_SKILL_CATEGARY_1;
	}
	public void setPRIMAERY_SKILL_CATEGARY_1(String pRIMAERY_SKILL_CATEGARY_1) {
		PRIMAERY_SKILL_CATEGARY_1 = pRIMAERY_SKILL_CATEGARY_1;
	}
	public String getPRIMAERY_SKILL_CATEGARY_2() {
		return PRIMAERY_SKILL_CATEGARY_2;
	}
	public void setPRIMAERY_SKILL_CATEGARY_2(String pRIMAERY_SKILL_CATEGARY_2) {
		PRIMAERY_SKILL_CATEGARY_2 = pRIMAERY_SKILL_CATEGARY_2;
	}
	public String getCOMMENTS() {
		return COMMENTS;
	}
	public void setCOMMENTS(String cOMMENTS) {
		COMMENTS = cOMMENTS;
	}
	public String getACCOUNT() {
		return ACCOUNT;
	}
	public void setACCOUNT(String aCCOUNT) {
		ACCOUNT = aCCOUNT;
	}
	public Timestamp getBILLING_START_DATE() {
		return BILLING_START_DATE;
	}
	public void setBILLING_START_DATE(Timestamp bILLING_START_DATE) {
		BILLING_START_DATE = bILLING_START_DATE;
	}
	public String getCATEGARY() {
		return CATEGARY;
	}
	public void setCATEGARY(String cATEGARY) {
		CATEGARY = cATEGARY;
	}
	public String getSUB_CATEGARY() {
		return SUB_CATEGARY;
	}
	public void setSUB_CATEGARY(String sUB_CATEGARY) {
		SUB_CATEGARY = sUB_CATEGARY;
	}
	public String getACTION_EMP_ID() {
		return ACTION_EMP_ID;
	}
	public void setACTION_EMP_ID(String aCTION_EMP_ID) {
		ACTION_EMP_ID = aCTION_EMP_ID;
	}
	public String getACTION_EMP_NAME() {
		return ACTION_EMP_NAME;
	}
	public void setACTION_EMP_NAME(String aCTION_EMP_NAME) {
		ACTION_EMP_NAME = aCTION_EMP_NAME;
	}
	public String getACTION_EMP_EMAIL() {
		return ACTION_EMP_EMAIL;
	}
	public void setACTION_EMP_EMAIL(String aCTION_EMP_EMAIL) {
		ACTION_EMP_EMAIL = aCTION_EMP_EMAIL;
	}
	
	
}
