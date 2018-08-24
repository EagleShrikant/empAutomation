package com.techmahindra.dao;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EMP_EXIT_ENTRY")
public class EntryExitDAO {

	@EmbeddedId
    private EntryExitPK entryExitPK;
	
	
	@Column(name = "EMP_NAME") private String EMPLOYEE_NAME;
	@Column(name = "BAND") private String BAND;
	@Column(name = "PROJECT_DESCRIPTION") private String PROJECT_DESCRIPTION;
	@Column(name = "PROGRAM_MANAGER_NAME") private String PROGRAM_MANAGER_NAME;
	public EntryExitPK getEntryExitPK() {
		return entryExitPK;
	}
	public void setEntryExitPK(EntryExitPK entryExitPK) {
		this.entryExitPK = entryExitPK;
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
	@Override
	public String toString() {
		return "EntryExitDAO [entryExitPK=" + entryExitPK + ", EMPLOYEE_NAME=" + EMPLOYEE_NAME + ", BAND=" + BAND
				+ ", PROJECT_DESCRIPTION=" + PROJECT_DESCRIPTION + ", PROGRAM_MANAGER_NAME=" + PROGRAM_MANAGER_NAME
				+ "]";
	}
	
	
	
	
	
}
