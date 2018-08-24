package com.techmahindra.model;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techmahindra.boot.MySQLAppConfig;
import com.techmahindra.dao.EntryExitDAO;
import com.techmahindra.dto.EntryExitRow;

@Component
public class EntryExitModel {

	@Autowired
	MySQLAppConfig mySQLAppConfig;
	
	List<EntryExitDAO> entryExitDataList;
	
	//@Autowired
	List <EntryExitRow> entryExitList;
	
	
	public List<EntryExitRow> getEntryExitTable() {
		entryExitModelDataFetch();
		setEntryExitTable(entryExitDataList);
		return entryExitList;
	}
	
	private List<EntryExitRow> setEntryExitTable(List<EntryExitDAO> entryExitDAOP) {
		entryExitList = new LinkedList<EntryExitRow>();		
		for (EntryExitDAO eeDAO : entryExitDAOP) {
			EntryExitRow tempRow = new EntryExitRow();
			tempRow.setDate(eeDAO.getEntryExitPK().getDATE());
			tempRow.setBand(eeDAO.getBAND());
			tempRow.setEmployeeID(eeDAO.getEntryExitPK().getEMPLOYEE_ID());
			tempRow.setEmployeeName(eeDAO.getEMPLOYEE_NAME());
			tempRow.setProgramManagerName(eeDAO.getPROGRAM_MANAGER_NAME());
			tempRow.setProjectDescription(eeDAO.getPROJECT_DESCRIPTION());
			tempRow.setStatus(eeDAO.getEntryExitPK().getSTATUS());
			entryExitList.add(tempRow);
		}
		return entryExitList;
		
	}

	public List<EntryExitDAO> entryExitModelDataFetch() {
		//entryExitList = new LinkedList<>();
		System.out.println("EntryExitDataFetch");
		Session session = mySQLAppConfig.getSessionFactory(mySQLAppConfig.getDataSource()).openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();

	         entryExitDataList = session.createQuery("from EntryExitDAO").list();
	         
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } catch (Exception e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }
	      
	      finally {
	         session.close(); 
	      }
	      
	      return entryExitDataList;
	}

}
