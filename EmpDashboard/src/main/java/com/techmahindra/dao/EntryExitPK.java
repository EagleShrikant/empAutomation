package com.techmahindra.dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EntryExitPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "DATE") private Date DATE;
	@Column(name = "ENTRY_OR_EXIT", length=20)  private String STATUS;
	@Column(name = "EMPLID", length=15) private String EMPLOYEE_ID;
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DATE == null) ? 0 : DATE.hashCode());
		result = prime * result + ((EMPLOYEE_ID == null) ? 0 : EMPLOYEE_ID.hashCode());
		result = prime * result + ((STATUS == null) ? 0 : STATUS.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntryExitPK other = (EntryExitPK) obj;
		if (DATE == null) {
			if (other.DATE != null)
				return false;
		} else if (!DATE.equals(other.DATE))
			return false;
		if (EMPLOYEE_ID == null) {
			if (other.EMPLOYEE_ID != null)
				return false;
		} else if (!EMPLOYEE_ID.equals(other.EMPLOYEE_ID))
			return false;
		if (STATUS == null) {
			if (other.STATUS != null)
				return false;
		} else if (!STATUS.equals(other.STATUS))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EntryExitPK [DATE=" + DATE + ", STATUS=" + STATUS + ", EMPLOYEE_ID=" + EMPLOYEE_ID + "]";
	}
    
	
}