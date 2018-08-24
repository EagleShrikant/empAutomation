package com.techmahindra.model;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techmahindra.boot.MySQLAppConfig;
import com.techmahindra.dao.CurrentEmployee;
import com.techmahindra.dto.SummaryRow;



@Component
public class SummaryModel {

	
	@Autowired
	MySQLAppConfig mySQLAppConfig;
	
	List<CurrentEmployee> currentDataList;
	
	//@Autowired
	List <SummaryRow> summaryList;
	
	//@Autowired
	//SummaryRow summary;
	
	public List<CurrentEmployee> SummaryModelDataFetch() {
		
		System.out.println("SummaryModelDataFetch");
		Session session = mySQLAppConfig.getSessionFactory(mySQLAppConfig.getDataSource()).openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();

	         currentDataList = session.createQuery("from CurrentEmployee").list();
	         
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
	      
	      return currentDataList;
	}
	
	//summary = new SummaryRow[10];

	
	public List<SummaryRow> getSummaryTable() {
		SummaryModelDataFetch();
		setSummaryTable(currentDataList);
		return summaryList;
	}
	
	public List<SummaryRow> setSummaryTable(List<CurrentEmployee> currentEmpList) {
		
		summaryList = new LinkedList<SummaryRow>();
		SummaryRow summaryDeliveryProjectsWithPO = new SummaryRow();
		// Delivery Projects with PO
		summaryDeliveryProjectsWithPO.setColumnRowName("Delivery Projects with PO");
		summaryDeliveryProjectsWithPO.setTotalOffshore(getDeliveryProjectswithPOTotalOffshore(currentEmpList));
		summaryDeliveryProjectsWithPO.setTotalOnsite(getDeliveryProjectswithPOTotalOnsite(currentEmpList));
		summaryDeliveryProjectsWithPO.setTotalAllocated(summaryDeliveryProjectsWithPO.getTotalOffshore() + summaryDeliveryProjectsWithPO.getTotalOnsite());
		summaryDeliveryProjectsWithPO.setUnbilledOffshore(getDeliveryProjectswithPOUnbilledOffshore(currentEmpList));
		summaryDeliveryProjectsWithPO.setUnbilledOnsite(getDeliveryProjectswithPOUnbilledOnsite(currentEmpList));
		summaryDeliveryProjectsWithPO.setDoNOTBILL(getDeliveryProjectswithPODoNOTBILL(currentEmpList));
		summaryDeliveryProjectsWithPO.setTotalUnbilled(summaryDeliveryProjectsWithPO.getUnbilledOffshore() + summaryDeliveryProjectsWithPO.getUnbilledOnsite());
		summaryDeliveryProjectsWithPO.setBilledOffshore( getDeliveryProjectswithPOBilledOffshore(currentEmpList));
		summaryDeliveryProjectsWithPO.setBilledOnsite(getDeliveryProjectswithPOBilledOnsite(currentEmpList));
		summaryDeliveryProjectsWithPO.setTotalBilled(summaryDeliveryProjectsWithPO.getBilledOffshore() + summaryDeliveryProjectsWithPO.getBilledOnsite());

		summaryList.add(summaryDeliveryProjectsWithPO);
		SummaryRow summaryDeliverywithoutPO = new SummaryRow();
		
		// Delivery without PO
		summaryDeliverywithoutPO.setColumnRowName("Delivery without PO");
		summaryDeliverywithoutPO.setTotalOffshore(getDeliverywithoutPOTotalOffshore(currentEmpList));
		summaryDeliverywithoutPO.setTotalOnsite(getDeliverywithoutPOTotalOnsite(currentEmpList));
		summaryDeliverywithoutPO.setTotalAllocated( summaryDeliverywithoutPO.getTotalOffshore() + summaryDeliverywithoutPO.getTotalOnsite());
		summaryDeliverywithoutPO.setUnbilledOffshore (getDeliverywithoutPOUnbilledOffshore(currentEmpList));
		summaryDeliverywithoutPO.setUnbilledOnsite ( getDeliverywithoutPOUnbilledOnsite(currentEmpList));
		summaryDeliverywithoutPO.setDoNOTBILL ( getDeliverywithoutPODoNOTBILL(currentEmpList));
		summaryDeliverywithoutPO.setTotalUnbilled( summaryDeliverywithoutPO.getUnbilledOffshore() + summaryDeliverywithoutPO.getUnbilledOnsite());
		summaryDeliverywithoutPO.setBilledOffshore ( getDeliverywithoutPOBilledOffshore(currentEmpList));
		summaryDeliverywithoutPO.setBilledOnsite ( getDeliverywithoutPOBilledOnsite(currentEmpList));
		summaryDeliverywithoutPO.setTotalBilled(  summaryDeliverywithoutPO.getBilledOffshore() + summaryDeliverywithoutPO.getBilledOnsite());

		summaryList.add(summaryDeliverywithoutPO);
		SummaryRow deliveryTotalsummary = new SummaryRow();
		
		// Delivery Total
		deliveryTotalsummary.setColumnRowName("Delivery Total");
		deliveryTotalsummary.setTotalOffshore ( summaryDeliveryProjectsWithPO.getTotalOffshore() + summaryDeliverywithoutPO.getTotalOffshore());
		deliveryTotalsummary.setTotalOnsite(  summaryDeliveryProjectsWithPO.getTotalOnsite() + summaryDeliverywithoutPO.getTotalOnsite());
		deliveryTotalsummary.setTotalAllocated ( summaryDeliveryProjectsWithPO.getTotalAllocated() + summaryDeliverywithoutPO.getTotalAllocated());
		deliveryTotalsummary.setUnbilledOffshore ( summaryDeliveryProjectsWithPO.getUnbilledOffshore() + summaryDeliverywithoutPO.getUnbilledOffshore());
		deliveryTotalsummary.setUnbilledOnsite ( summaryDeliveryProjectsWithPO.getUnbilledOnsite() + summaryDeliverywithoutPO.getUnbilledOnsite());
		deliveryTotalsummary.setDoNOTBILL ( summaryDeliveryProjectsWithPO.getDoNOTBILL() + summaryDeliverywithoutPO.getDoNOTBILL());
		deliveryTotalsummary.setTotalUnbilled( summaryDeliveryProjectsWithPO.getTotalUnbilled() + summaryDeliverywithoutPO.getTotalUnbilled());
		deliveryTotalsummary.setBilledOffshore ( summaryDeliveryProjectsWithPO.getBilledOffshore() + summaryDeliverywithoutPO.getBilledOffshore());
		deliveryTotalsummary.setBilledOnsite ( summaryDeliveryProjectsWithPO.getBilledOnsite() + summaryDeliverywithoutPO.getBilledOnsite());
		deliveryTotalsummary.setTotalBilled( summaryDeliveryProjectsWithPO.getTotalBilled() + summaryDeliverywithoutPO.getTotalBilled());

		summaryList.add(deliveryTotalsummary);
		SummaryRow deliveryWDSummary = new SummaryRow();
		
		// Delivery WD
		deliveryWDSummary.setColumnRowName("Delivery WD");
		deliveryWDSummary.setTotalOffshore ( getDeliveryWDTotalOffshore(currentEmpList));
		deliveryWDSummary.setTotalOnsite(  getDeliveryWDTotalOnsite(currentEmpList));
		deliveryWDSummary.setTotalAllocated ( deliveryWDSummary.getTotalOffshore() + deliveryWDSummary.getTotalOnsite());
		deliveryWDSummary.setUnbilledOffshore ( getDeliveryWDUnbilledOffshore(currentEmpList));
		deliveryWDSummary.setUnbilledOnsite ( getDeliveryWDUnbilledOnsite(currentEmpList));
		deliveryWDSummary.setDoNOTBILL ( getDeliveryWDDoNOTBILL(currentEmpList));
		deliveryWDSummary.setTotalUnbilled( deliveryWDSummary.getUnbilledOffshore() + deliveryWDSummary.getUnbilledOnsite());
		deliveryWDSummary.setBilledOffshore ( getDeliveryWDBilledOffshore(currentEmpList));
		deliveryWDSummary.setBilledOnsite ( getDeliveryWDBilledOnsite(currentEmpList));
		deliveryWDSummary.setTotalBilled(  deliveryWDSummary.getBilledOffshore() + deliveryWDSummary.getBilledOnsite());

		summaryList.add(deliveryWDSummary);
		SummaryRow mENoPOAmericasSummary = new SummaryRow();
		
		// ME No PO Americas
		mENoPOAmericasSummary.setColumnRowName("ME No PO Americas");
		mENoPOAmericasSummary.setTotalOffshore ( getMENoPOAmericasTotalOffshore(currentEmpList));
		mENoPOAmericasSummary.setTotalOnsite(  getMENoPOAmericasTotalOnsite(currentEmpList));
		mENoPOAmericasSummary.setTotalAllocated ( mENoPOAmericasSummary.getTotalOffshore() + mENoPOAmericasSummary.getTotalOnsite());
		mENoPOAmericasSummary.setUnbilledOffshore ( getMENoPOAmericasUnbilledOffshore(currentEmpList));
		mENoPOAmericasSummary.setUnbilledOnsite ( getMENoPOAmericasUnbilledOnsite(currentEmpList));
		mENoPOAmericasSummary.setDoNOTBILL ( getMENoPOAmericasDoNOTBILL(currentEmpList));
		mENoPOAmericasSummary.setTotalUnbilled( mENoPOAmericasSummary.getUnbilledOffshore() + mENoPOAmericasSummary.getUnbilledOnsite());
		mENoPOAmericasSummary.setBilledOffshore ( getMENoPOAmericasBilledOffshore(currentEmpList));
		mENoPOAmericasSummary.setBilledOnsite ( getMENoPOAmericasBilledOnsite(currentEmpList));
		mENoPOAmericasSummary.setTotalBilled(  mENoPOAmericasSummary.getBilledOffshore() + mENoPOAmericasSummary.getBilledOnsite());
		summaryList.add(mENoPOAmericasSummary);
		SummaryRow OtherInvestmentsummary = new SummaryRow();
		
		// Other Investment
		OtherInvestmentsummary.setColumnRowName("Other Investment");
		OtherInvestmentsummary.setTotalOffshore ( getOtherInvestmentTotalOffshore(currentEmpList));
		OtherInvestmentsummary.setTotalOnsite(  getOtherInvestmentTotalOnsite(currentEmpList));
		OtherInvestmentsummary.setTotalAllocated ( OtherInvestmentsummary.getTotalOffshore() + OtherInvestmentsummary.getTotalOnsite());
		OtherInvestmentsummary.setUnbilledOffshore ( getOtherInvestmentUnbilledOffshore(currentEmpList));
		OtherInvestmentsummary.setUnbilledOnsite ( getOtherInvestmentUnbilledOnsite(currentEmpList));
		OtherInvestmentsummary.setDoNOTBILL ( getOtherInvestmentDoNOTBILL(currentEmpList));
		OtherInvestmentsummary.setTotalUnbilled( OtherInvestmentsummary.getUnbilledOffshore() + OtherInvestmentsummary.getUnbilledOnsite());
		OtherInvestmentsummary.setBilledOffshore ( getOtherInvestmentBilledOffshore(currentEmpList));
		OtherInvestmentsummary.setBilledOnsite ( getOtherInvestmentBilledOnsite(currentEmpList));
		OtherInvestmentsummary.setTotalBilled(  OtherInvestmentsummary.getBilledOffshore() + OtherInvestmentsummary.getBilledOnsite());
		
		summaryList.add(OtherInvestmentsummary);
		SummaryRow pipelineProjectSummary = new SummaryRow();
		
		// Pipeline Project
		pipelineProjectSummary.setColumnRowName("Pipeline Project");
		pipelineProjectSummary.setTotalOffshore ( getPipelineProjectTotalOffshore(currentEmpList));
		pipelineProjectSummary.setTotalOnsite(  getPipelineProjectTotalOnsite(currentEmpList));
		pipelineProjectSummary.setTotalAllocated ( pipelineProjectSummary.getTotalOffshore() + pipelineProjectSummary.getTotalOnsite());
		pipelineProjectSummary.setUnbilledOffshore ( getPipelineProjectUnbilledOffshore(currentEmpList));
		pipelineProjectSummary.setUnbilledOnsite ( getPipelineProjectUnbilledOnsite(currentEmpList));
		pipelineProjectSummary.setDoNOTBILL ( getPipelineProjectDoNOTBILL(currentEmpList));
		pipelineProjectSummary.setTotalUnbilled( pipelineProjectSummary.getUnbilledOffshore() + pipelineProjectSummary.getUnbilledOnsite());
		pipelineProjectSummary.setBilledOffshore ( getPipelineProjectBilledOffshore(currentEmpList));
		pipelineProjectSummary.setBilledOnsite ( getPipelineProjectBilledOnsite(currentEmpList));
		pipelineProjectSummary.setTotalBilled(  pipelineProjectSummary.getBilledOffshore() + pipelineProjectSummary.getBilledOnsite());
		summaryList.add(pipelineProjectSummary);
		SummaryRow managementprojectSummary = new SummaryRow();
		
		// Management Project
		managementprojectSummary.setColumnRowName("Management Project");
		managementprojectSummary.setTotalOffshore ( getManagementProjectTotalOffshore(currentEmpList));
		managementprojectSummary.setTotalOnsite(  getManagementProjectTotalOnsite(currentEmpList));
		managementprojectSummary.setTotalAllocated ( managementprojectSummary.getTotalOffshore() + managementprojectSummary.getTotalOnsite());
		managementprojectSummary.setUnbilledOffshore ( getManagementProjectUnbilledOffshore(currentEmpList));
		managementprojectSummary.setUnbilledOnsite ( getManagementProjectUnbilledOnsite(currentEmpList));
		managementprojectSummary.setDoNOTBILL ( getManagementProjectDoNOTBILL(currentEmpList));
		managementprojectSummary.setTotalUnbilled( managementprojectSummary.getUnbilledOffshore() + managementprojectSummary.getUnbilledOnsite());
		managementprojectSummary.setBilledOffshore ( getManagementProjectBilledOffshore(currentEmpList));
		managementprojectSummary.setBilledOnsite ( getManagementProjectBilledOnsite(currentEmpList));
		managementprojectSummary.setTotalBilled(  managementprojectSummary.getBilledOffshore() + managementprojectSummary.getBilledOnsite());

		summaryList.add(managementprojectSummary);
		SummaryRow nonDeliverySubTotalsummary = new SummaryRow();
		
		// Non Delivery Sub Total
		nonDeliverySubTotalsummary.setColumnRowName("Non Delivery Sub Total");
		nonDeliverySubTotalsummary.setTotalOffshore ( deliveryWDSummary.getTotalOffshore() + mENoPOAmericasSummary.getTotalOffshore() + OtherInvestmentsummary.getTotalOffshore() + pipelineProjectSummary.getTotalOffshore() + managementprojectSummary.getTotalOffshore());
		nonDeliverySubTotalsummary.setTotalOnsite(  deliveryWDSummary.getTotalOnsite() + mENoPOAmericasSummary.getTotalOnsite() + OtherInvestmentsummary.getTotalOnsite() + pipelineProjectSummary.getTotalOnsite() + managementprojectSummary.getTotalOnsite());
		nonDeliverySubTotalsummary.setTotalAllocated ( deliveryWDSummary.getTotalAllocated() + mENoPOAmericasSummary.getTotalAllocated() + OtherInvestmentsummary.getTotalAllocated() + pipelineProjectSummary.getTotalAllocated() + managementprojectSummary.getTotalAllocated());
		nonDeliverySubTotalsummary.setUnbilledOffshore ( deliveryWDSummary.getUnbilledOffshore() + mENoPOAmericasSummary.getUnbilledOffshore() + OtherInvestmentsummary.getUnbilledOffshore() + pipelineProjectSummary.getUnbilledOffshore() + managementprojectSummary.getUnbilledOffshore());
		nonDeliverySubTotalsummary.setUnbilledOnsite ( deliveryWDSummary.getUnbilledOnsite() + mENoPOAmericasSummary.getUnbilledOnsite() + OtherInvestmentsummary.getUnbilledOnsite() + pipelineProjectSummary.getUnbilledOnsite() + managementprojectSummary.getUnbilledOnsite());
		nonDeliverySubTotalsummary.setDoNOTBILL ( deliveryWDSummary.getDoNOTBILL() + mENoPOAmericasSummary.getDoNOTBILL() + OtherInvestmentsummary.getDoNOTBILL() + pipelineProjectSummary.getDoNOTBILL() + managementprojectSummary.getDoNOTBILL());
		nonDeliverySubTotalsummary.setTotalUnbilled( deliveryWDSummary.getTotalUnbilled()+ mENoPOAmericasSummary.getTotalUnbilled()+ OtherInvestmentsummary.getTotalUnbilled()+ pipelineProjectSummary.getTotalUnbilled()+ managementprojectSummary.getTotalUnbilled());
		nonDeliverySubTotalsummary.setBilledOffshore ( deliveryWDSummary.getBilledOffshore() + mENoPOAmericasSummary.getBilledOffshore() + OtherInvestmentsummary.getBilledOffshore() + pipelineProjectSummary.getBilledOffshore() + managementprojectSummary.getBilledOffshore());
		nonDeliverySubTotalsummary.setBilledOnsite ( deliveryWDSummary.getBilledOnsite() + mENoPOAmericasSummary.getBilledOnsite() + OtherInvestmentsummary.getBilledOnsite() + pipelineProjectSummary.getBilledOnsite() + managementprojectSummary.getBilledOnsite());
		nonDeliverySubTotalsummary.setTotalBilled(  deliveryWDSummary.getTotalBilled() + mENoPOAmericasSummary.getTotalBilled() + OtherInvestmentsummary.getTotalBilled() + pipelineProjectSummary.getTotalBilled() + managementprojectSummary.getTotalBilled());
		summaryList.add(nonDeliverySubTotalsummary);
		SummaryRow bufferSummary = new SummaryRow();
		
		// Buffer
		bufferSummary.setColumnRowName("Buffer");
		bufferSummary.setTotalOffshore ( getBufferTotalOffshore(currentEmpList));
		bufferSummary.setTotalOnsite(  getBufferTotalOnsite(currentEmpList));
		bufferSummary.setTotalAllocated ( bufferSummary.getTotalOffshore() + bufferSummary.getTotalOnsite());
		bufferSummary.setUnbilledOffshore ( getBufferUnbilledOffshore(currentEmpList));
		bufferSummary.setUnbilledOnsite ( getBufferUnbilledOnsite(currentEmpList));
		bufferSummary.setDoNOTBILL ( getBufferDoNOTBILL(currentEmpList));
		bufferSummary.setTotalUnbilled( bufferSummary.getUnbilledOffshore() + bufferSummary.getUnbilledOnsite());
		bufferSummary.setBilledOffshore ( getBufferBilledOffshore(currentEmpList));
		bufferSummary.setBilledOnsite ( getBufferBilledOnsite(currentEmpList));
		bufferSummary.setTotalBilled( bufferSummary.getBilledOffshore() + bufferSummary.getBilledOnsite());
		
		summaryList.add(bufferSummary);
		
		
		// Grand Total
		SummaryRow grandTotalSummary = new SummaryRow();
		
		grandTotalSummary.setColumnRowName("Grand Total");
		grandTotalSummary.setTotalOffshore ( deliveryTotalsummary.getTotalOffshore() + nonDeliverySubTotalsummary.getTotalOffshore() + bufferSummary.getTotalOffshore());
		grandTotalSummary.setTotalOnsite( deliveryTotalsummary.getTotalOnsite() + nonDeliverySubTotalsummary.getTotalOnsite() + bufferSummary.getTotalOnsite());
		grandTotalSummary.setTotalAllocated ( deliveryTotalsummary.getTotalAllocated() + nonDeliverySubTotalsummary.getTotalAllocated() + bufferSummary.getTotalAllocated());
		grandTotalSummary.setUnbilledOffshore (deliveryTotalsummary.getUnbilledOffshore() + nonDeliverySubTotalsummary.getUnbilledOffshore() + bufferSummary.getUnbilledOffshore());
		grandTotalSummary.setUnbilledOnsite ( deliveryTotalsummary.getUnbilledOnsite() + nonDeliverySubTotalsummary.getUnbilledOnsite() + bufferSummary.getUnbilledOnsite());
		grandTotalSummary.setDoNOTBILL ( deliveryTotalsummary.getDoNOTBILL() + nonDeliverySubTotalsummary.getDoNOTBILL() + bufferSummary.getDoNOTBILL());
		grandTotalSummary.setTotalUnbilled( deliveryTotalsummary.getTotalUnbilled() + nonDeliverySubTotalsummary.getTotalUnbilled() + bufferSummary.getTotalUnbilled());
		grandTotalSummary.setBilledOffshore ( deliveryTotalsummary.getBilledOffshore() + nonDeliverySubTotalsummary.getBilledOffshore() + bufferSummary.getBilledOffshore());
		grandTotalSummary.setBilledOnsite ( deliveryTotalsummary.getBilledOnsite() + nonDeliverySubTotalsummary.getBilledOnsite() + bufferSummary.getBilledOnsite());
		grandTotalSummary.setTotalBilled( deliveryTotalsummary.getTotalBilled() + nonDeliverySubTotalsummary.getTotalBilled() + bufferSummary.getTotalBilled());
		summaryList.add(grandTotalSummary);
		return summaryList;
		
	}

	private int getBufferBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if( ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("NA")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("N")) && ce.getEMPLOYEE_CLASS_CATEGORY().equalsIgnoreCase("Designated- Non Billable(DNB)")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////

	private int getManagementProjectBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if( ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("NA")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("N")) && ce.getEMPLOYEE_CLASS_CATEGORY().equalsIgnoreCase("Designated- Non Billable(DNB)")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getPipelineProjectBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Pipeline") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getPipelineProjectBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Pipeline") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getPipelineProjectDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if( ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("NA")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Pipeline") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("N")) && ce.getEMPLOYEE_CLASS_CATEGORY().equalsIgnoreCase("Designated- Non Billable(DNB)")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getPipelineProjectUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Pipeline") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getPipelineProjectUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Pipeline") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getPipelineProjectTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Pipeline") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getPipelineProjectTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Pipeline") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getOtherInvestmentBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if( ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("NA")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("N")) && ce.getEMPLOYEE_CLASS_CATEGORY().equalsIgnoreCase("Designated- Non Billable(DNB)")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getMENoPOAmericasBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Disney Investment") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Disney Investment") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if( ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("NA")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Disney Investment") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("N")) && ce.getEMPLOYEE_CLASS_CATEGORY().equalsIgnoreCase("Designated- Non Billable(DNB)")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if((((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Disney Investment")) && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Disney Investment") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Disney Investment") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Disney Investment")) {
	        	temp ++;
	        }
		}
		return temp;
		
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getDeliveryWDBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Ingram Investment") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Ingram Investment") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if( ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("NA")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Ingram Investment") && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("N")) && ce.getEMPLOYEE_CLASS_CATEGORY().equalsIgnoreCase("Designated- Non Billable(DNB)")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Ingram Investment") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ce.getPROJECT_TYPE().equalsIgnoreCase("Ingram Investment") && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Ingram Investment") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDTotalOnsite(List<CurrentEmployee> currentEmpList) {
		 
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Ingram Investment") && ((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE"))) {
	        	temp ++;
	        }
		}
		return temp;
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getDeliverywithoutPOBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && (null!= ce.getPO_FLAG() && ce.getPO_FLAG().equalsIgnoreCase("N"))&& (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPOBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && (null!= ce.getPO_FLAG() && ce.getPO_FLAG().equalsIgnoreCase("N")) && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPODoNOTBILL(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			if(((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("N")) && (null!= ce.getPROJECT_TYPE() && ce.getPROJECT_TYPE().equalsIgnoreCase("Delivery")) && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("N")) && ce.getEMPLOYEE_CLASS_CATEGORY().equalsIgnoreCase("Designated- Non Billable(DNB)")) {
				temp++;
				
			}
		}
		return temp;
	}

	private int getDeliverywithoutPOUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && (null!= ce.getPO_FLAG() && ce.getPO_FLAG().equalsIgnoreCase("N"))&& (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPOUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && (null!= ce.getPO_FLAG() && ce.getPO_FLAG().equalsIgnoreCase("N")) && (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPOTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && (null!= ce.getPO_FLAG() && ce.getPO_FLAG().equalsIgnoreCase("N"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPOTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && (null!= ce.getPO_FLAG() && ce.getPO_FLAG().equalsIgnoreCase("N"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getDeliveryProjectswithPOBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("Y"))&& (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPOBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("Y")) && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPODoNOTBILL(List<CurrentEmployee> currentEmpList) {

		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			if(((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("Y")) && (null!= ce.getPROJECT_TYPE() && ce.getPROJECT_TYPE().equalsIgnoreCase("Delivery")) && (null!=ce.getBILLABLITY_STATUS() && ce.getBILLABLITY_STATUS().equalsIgnoreCase("N")) && ce.getEMPLOYEE_CLASS_CATEGORY().equalsIgnoreCase("Designated- Non Billable(DNB)")) {
				temp++;
				
			}
		}
		return temp;
	}

	private int getDeliveryProjectswithPOUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("Y"))&& (null!=ce.getBILLABLITY_STATUS() && !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPOUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("Y")) && (null!=ce.getBILLABLITY_STATUS() &&  !(ce.getBILLABLITY_STATUS().equalsIgnoreCase("Y")))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPOTotalOnsite(List<CurrentEmployee> currentEmpList) {
		
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) && ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPOTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
	        if(((null!= ce.getONSITE_OFFSHORE()) && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) && ((null!= ce.getPO_FLAG()) && ce.getPO_FLAG().equalsIgnoreCase("Y"))) {
	        	temp ++;
	        }
		}
		
		return temp;
	}
}
