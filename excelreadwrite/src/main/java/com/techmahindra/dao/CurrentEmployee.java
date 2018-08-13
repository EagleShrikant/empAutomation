package com.techmahindra.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENT_EMP_DATA")
public class CurrentEmployee {

	@Id
	@Column(name = "EMPID", length=11 ) private String EMPID; 
	
	@Column(name = "EMP_NAME", length=50) private String EMP_NAME;
    @Column(name = "BUSINESS_WAIT_AGE" ) private int BUSINESS_WAIT_AGE;
    @Column(name = "BV_STATUS",length=11) private String BV_STATUS;
    @Column(name = "EMPLOYEE_CLASS_CATEGORY",length=50) private String EMPLOYEE_CLASS_CATEGORY;
    @Column(name = "GENDER",length=50) private String GENDER;
    @Column(name = "CATEGORY_CODE",length=50) private String CATEGORY_CODE;
    @Column(name = "HTR_FLAG",length=50) private String HTR_FLAG;
    @Column(name = "EMPLOYEE_IBU",length=50) private String EMPLOYEE_IBU;
    @Column(name = "BAND",length=50) private String BAND;
    @Column(name = "TOTAL_EXPERIENCE",length=50) private double TOTAL_EXPERIENCE;
    @Column(name = "CURRENT_COUNTRY",length=50) private String CURRENT_COUNTRY;
    @Column(name = "CURRENT_LOCATION_CITY",length=50) private String CURRENT_LOCATION_CITY;
    @Column(name = "ONSITE_OFFSHORE",length=50) private String ONSITE_OFFSHORE;
    @Column(name = "PROJECT_ID",length=50) private String PROJECT_ID;
    @Column(name = "PROJECT_DESCRIPTION",length=70) private String PROJECT_DESCRIPTION;
    @Column(name = "PROJECT_CONTRACT_TYPE",length=50) private String PROJECT_CONTRACT_TYPE;
    @Column(name = "PROJECT_MAINTYPE_DESCR",length=50) private String PROJECT_MAINTYPE_DESCR;
    @Column(name = "BILLABLITY_STATUS",length=50) private boolean BILLABLITY_STATUS;
    @Column(name = "CUSTOMER_ID",length=50) private String CUSTOMER_ID;
    @Column(name = "CUSTOMER_NAME",length=50) private String CUSTOMER_NAME;
    @Column(name = "SUPERVISOR_ID",length=50) private String SUPERVISOR_ID;
    @Column(name = "SUPERVISOR_NAME",length=50) private String SUPERVISOR_NAME;
    @Column(name = "PROGRAM_MANAGER_ID",length=50) private String PROGRAM_MANAGER_ID;
    @Column(name = "PROGRAM_MANAGER_NAME",length=50) private String PROGRAM_MANAGER_NAME;
    @Column(name = "PRIMARY_SKILL_CATEGORY_1",length=50) private String PRIMARY_SKILL_CATEGORY_1;
    @Column(name = "PRIMARY_SKILL_CATEGORY_2",length=50) private String PRIMARY_SKILL_CATEGORY_2;
    @Column(name = "PROJECT_TYPE",length=50) private String PROJECT_TYPE;
    @Column(name = "PO_FLAG",length=10) private String PO_FLAG;
	public String getEMPID() {
		return EMPID;
	}
	public void setEMPID(String eMPID) {
		EMPID = eMPID;
	}
	public String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}
	public int getBUSINESS_WAIT_AGE() {
		return BUSINESS_WAIT_AGE;
	}
	public void setBUSINESS_WAIT_AGE(int bUSINESS_WAIT_AGE) {
		BUSINESS_WAIT_AGE = bUSINESS_WAIT_AGE;
	}
	public String getBV_STATUS() {
		return BV_STATUS;
	}
	public void setBV_STATUS(String bV_STATUS) {
		BV_STATUS = bV_STATUS;
	}
	public String getEMPLOYEE_CLASS_CATEGORY() {
		return EMPLOYEE_CLASS_CATEGORY;
	}
	public void setEMPLOYEE_CLASS_CATEGORY(String eMPLOYEE_CLASS_CATEGORY) {
		EMPLOYEE_CLASS_CATEGORY = eMPLOYEE_CLASS_CATEGORY;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getCATEGORY_CODE() {
		return CATEGORY_CODE;
	}
	public void setCATEGORY_CODE(String cATEGORY_CODE) {
		CATEGORY_CODE = cATEGORY_CODE;
	}
	public String getHTR_FLAG() {
		return HTR_FLAG;
	}
	public void setHTR_FLAG(String hTR_FLAG) {
		HTR_FLAG = hTR_FLAG;
	}
	public String getEMPLOYEE_IBU() {
		return EMPLOYEE_IBU;
	}
	public void setEMPLOYEE_IBU(String eMPLOYEE_IBU) {
		EMPLOYEE_IBU = eMPLOYEE_IBU;
	}
	public String getBAND() {
		return BAND;
	}
	public void setBAND(String bAND) {
		BAND = bAND;
	}
	public double getTOTAL_EXPERIENCE() {
		return TOTAL_EXPERIENCE;
	}
	public void setTOTAL_EXPERIENCE(double tOTAL_EXPERIENCE) {
		TOTAL_EXPERIENCE = tOTAL_EXPERIENCE;
	}
	public String getCURRENT_COUNTRY() {
		return CURRENT_COUNTRY;
	}
	public void setCURRENT_COUNTRY(String cURRENT_COUNTRY) {
		CURRENT_COUNTRY = cURRENT_COUNTRY;
	}
	public String getCURRENT_LOCATION_CITY() {
		return CURRENT_LOCATION_CITY;
	}
	public void setCURRENT_LOCATION_CITY(String cURRENT_LOCATION_CITY) {
		CURRENT_LOCATION_CITY = cURRENT_LOCATION_CITY;
	}
	public String getONSITE_OFFSHORE() {
		return ONSITE_OFFSHORE;
	}
	public void setONSITE_OFFSHORE(String oNSITE_OFFSHORE) {
		ONSITE_OFFSHORE = oNSITE_OFFSHORE;
	}
	public String getPROJECT_ID() {
		return PROJECT_ID;
	}
	public void setPROJECT_ID(String pROJECT_ID) {
		PROJECT_ID = pROJECT_ID;
	}
	public String getPROJECT_DESCRIPTION() {
		return PROJECT_DESCRIPTION;
	}
	public void setPROJECT_DESCRIPTION(String pROJECT_DESCRIPTION) {
		PROJECT_DESCRIPTION = pROJECT_DESCRIPTION;
	}
	public String getPROJECT_CONTRACT_TYPE() {
		return PROJECT_CONTRACT_TYPE;
	}
	public void setPROJECT_CONTRACT_TYPE(String pROJECT_CONTRACT_TYPE) {
		PROJECT_CONTRACT_TYPE = pROJECT_CONTRACT_TYPE;
	}
	public String getPROJECT_MAINTYPE_DESCR() {
		return PROJECT_MAINTYPE_DESCR;
	}
	public void setPROJECT_MAINTYPE_DESCR(String pROJECT_MAINTYPE_DESCR) {
		PROJECT_MAINTYPE_DESCR = pROJECT_MAINTYPE_DESCR;
	}
	public boolean isBILLABLITY_STATUS() {
		return BILLABLITY_STATUS;
	}
	public void setBILLABLITY_STATUS(boolean bILLABLITY_STATUS) {
		BILLABLITY_STATUS = bILLABLITY_STATUS;
	}
	public String getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(String cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public String getSUPERVISOR_ID() {
		return SUPERVISOR_ID;
	}
	public void setSUPERVISOR_ID(String sUPERVISOR_ID) {
		SUPERVISOR_ID = sUPERVISOR_ID;
	}
	public String getSUPERVISOR_NAME() {
		return SUPERVISOR_NAME;
	}
	public void setSUPERVISOR_NAME(String sUPERVISOR_NAME) {
		SUPERVISOR_NAME = sUPERVISOR_NAME;
	}
	public String getPROGRAM_MANAGER_ID() {
		return PROGRAM_MANAGER_ID;
	}
	public void setPROGRAM_MANAGER_ID(String pROGRAM_MANAGER_ID) {
		PROGRAM_MANAGER_ID = pROGRAM_MANAGER_ID;
	}
	public String getPROGRAM_MANAGER_NAME() {
		return PROGRAM_MANAGER_NAME;
	}
	public void setPROGRAM_MANAGER_NAME(String pROGRAM_MANAGER_NAME) {
		PROGRAM_MANAGER_NAME = pROGRAM_MANAGER_NAME;
	}
	public String getPRIMARY_SKILL_CATEGORY_1() {
		return PRIMARY_SKILL_CATEGORY_1;
	}
	public void setPRIMARY_SKILL_CATEGORY_1(String pRIMARY_SKILL_CATEGORY_1) {
		PRIMARY_SKILL_CATEGORY_1 = pRIMARY_SKILL_CATEGORY_1;
	}
	public String getPRIMARY_SKILL_CATEGORY_2() {
		return PRIMARY_SKILL_CATEGORY_2;
	}
	public void setPRIMARY_SKILL_CATEGORY_2(String pRIMARY_SKILL_CATEGORY_2) {
		PRIMARY_SKILL_CATEGORY_2 = pRIMARY_SKILL_CATEGORY_2;
	}
	public String getPROJECT_TYPE() {
		return PROJECT_TYPE;
	}
	public void setPROJECT_TYPE(String pROJECT_TYPE) {
		PROJECT_TYPE = pROJECT_TYPE;
	}
	public String getPO_FLAG() {
		return PO_FLAG;
	}
	public void setPO_FLAG(String PO_FLAG) {
		this.PO_FLAG = PO_FLAG;
	}
	@Override
	public String toString() {
		return "\nCurrentEmployee [EMPID=" + EMPID + ", EMP_NAME=" + EMP_NAME + ", BUSINESS_WAIT_AGE=" + BUSINESS_WAIT_AGE
				+ ", BV_STATUS=" + BV_STATUS + ", EMPLOYEE_CLASS_CATEGORY=" + EMPLOYEE_CLASS_CATEGORY + ", GENDER="
				+ GENDER + ", CATEGORY_CODE=" + CATEGORY_CODE + ", HTR_FLAG=" + HTR_FLAG + ", EMPLOYEE_IBU="
				+ EMPLOYEE_IBU + ", BAND=" + BAND + ", TOTAL_EXPERIENCE=" + TOTAL_EXPERIENCE + ", CURRENT_COUNTRY="
				+ CURRENT_COUNTRY + ", CURRENT_LOCATION_CITY=" + CURRENT_LOCATION_CITY + ", ONSITE_OFFSHORE="
				+ ONSITE_OFFSHORE + ", PROJECT_ID=" + PROJECT_ID + ", PROJECT_DESCRIPTION=" + PROJECT_DESCRIPTION
				+ ", PROJECT_CONTRACT_TYPE=" + PROJECT_CONTRACT_TYPE + ", PROJECT_MAINTYPE_DESCR="
				+ PROJECT_MAINTYPE_DESCR + ", BILLABLITY_STATUS=" + BILLABLITY_STATUS + ", CUSTOMER_ID=" + CUSTOMER_ID
				+ ", CUSTOMER_NAME=" + CUSTOMER_NAME + ", SUPERVISOR_ID=" + SUPERVISOR_ID + ", SUPERVISOR_NAME="
				+ SUPERVISOR_NAME + ", PROGRAM_MANAGER_ID=" + PROGRAM_MANAGER_ID + ", PROGRAM_MANAGER_NAME="
				+ PROGRAM_MANAGER_NAME + ", PRIMARY_SKILL_CATEGORY_1=" + PRIMARY_SKILL_CATEGORY_1
				+ ", PRIMARY_SKILL_CATEGORY_2=" + PRIMARY_SKILL_CATEGORY_2 + ", PROJECT_TYPE=" + PROJECT_TYPE
				+ ", PO_FLAG=" + PO_FLAG + "]";
	}
    
    
}
