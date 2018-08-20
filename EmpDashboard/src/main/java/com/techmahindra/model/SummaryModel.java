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
		SummaryRow summary = new SummaryRow();
		
		// Delivery Total
		summary.setColumnRowName("Delivery Total");
		summary.setTotalOffshore ( summary.getTotalOffshore() + summary.getTotalOffshore());
		summary.setTotalOnsite(  summary.getTotalOnsite() + summary.getTotalOnsite());
		summary.setTotalAllocated ( summary.getTotalOffshore() + summary.getTotalOnsite());
		summary.setUnbilledOffshore ( summary.getUnbilledOffshore() + summary.getUnbilledOffshore());
		summary.setUnbilledOnsite ( summary.getUnbilledOnsite() + summary.getUnbilledOnsite());
		summary.setDoNOTBILL ( summary.getDoNOTBILL() + summary.getDoNOTBILL());
		summary.setTotalUnbilled( summary.getTotalUnbilled() + summary.getTotalUnbilled());
		summary.setBilledOffshore ( summary.getBilledOffshore() + summary.getBilledOffshore());
		summary.setBilledOnsite ( summary.getBilledOnsite() + summary.getBilledOnsite());
		summary.setTotalBilled( summary.getTotalBilled() + summary.getTotalBilled());

		summaryList.add(summary);
		summary = new SummaryRow();
		
		// Delivery WD
		summary.setColumnRowName("Delivery WD");
		summary.setTotalOffshore ( getDeliveryWDTotalOffshore(currentEmpList));
		summary.setTotalOnsite(  getDeliveryWDTotalOnsite(currentEmpList));
		summary.setTotalAllocated ( summary.getTotalOffshore() + summary.getTotalOnsite());
		summary.setUnbilledOffshore ( getDeliveryWDUnbilledOffshore(currentEmpList));
		summary.setUnbilledOnsite ( getDeliveryWDUnbilledOnsite(currentEmpList));
		summary.setDoNOTBILL ( getDeliveryWDDoNOTBILL(currentEmpList));
		summary.setTotalUnbilled( summary.getUnbilledOffshore() + summary.getUnbilledOnsite());
		summary.setBilledOffshore ( getDeliveryWDBilledOffshore(currentEmpList));
		summary.setBilledOnsite ( getDeliveryWDBilledOnsite(currentEmpList));
		summary.setTotalBilled(  summary.getBilledOffshore() + summary.getBilledOnsite());

		summaryList.add(summary);
		summary = new SummaryRow();
		
		// ME No PO Americas
		summary.setColumnRowName("ME No PO Americas");
		summary.setTotalOffshore ( getMENoPOAmericasTotalOffshore(currentEmpList));
		summary.setTotalOnsite(  getMENoPOAmericasTotalOnsite(currentEmpList));
		summary.setTotalAllocated ( summary.getTotalOffshore() + summary.getTotalOnsite());
		summary.setUnbilledOffshore ( getMENoPOAmericasUnbilledOffshore(currentEmpList));
		summary.setUnbilledOnsite ( getMENoPOAmericasUnbilledOnsite(currentEmpList));
		summary.setDoNOTBILL ( getMENoPOAmericasDoNOTBILL(currentEmpList));
		summary.setTotalUnbilled( summary.getUnbilledOffshore() + summary.getUnbilledOnsite());
		summary.setBilledOffshore ( getMENoPOAmericasBilledOffshore(currentEmpList));
		summary.setBilledOnsite ( getMENoPOAmericasBilledOnsite(currentEmpList));
		summary.setTotalBilled(  summary.getBilledOffshore() + summary.getBilledOnsite());
		summaryList.add(summary);
		summary = new SummaryRow();
		
		// Other Investment
		summary.setColumnRowName("Other Investment");
		summary.setTotalOffshore ( getOtherInvestmentTotalOffshore(currentEmpList));
		summary.setTotalOnsite(  getOtherInvestmentTotalOnsite(currentEmpList));
		summary.setTotalAllocated ( summary.getTotalOffshore() + summary.getTotalOnsite());
		summary.setUnbilledOffshore ( getOtherInvestmentUnbilledOffshore(currentEmpList));
		summary.setUnbilledOnsite ( getOtherInvestmentUnbilledOnsite(currentEmpList));
		summary.setDoNOTBILL ( getOtherInvestmentDoNOTBILL(currentEmpList));
		summary.setTotalUnbilled( summary.getUnbilledOffshore() + summary.getUnbilledOnsite());
		summary.setBilledOffshore ( getOtherInvestmentBilledOffshore(currentEmpList));
		summary.setBilledOnsite ( getOtherInvestmentBilledOnsite(currentEmpList));
		summary.setTotalBilled(  summary.getBilledOffshore() + summary.getBilledOnsite());
		
		summaryList.add(summary);
		summary = new SummaryRow();
		// Pipeline Project
		summary.setColumnRowName("Pipeline Project");
		summary.setTotalOffshore ( getPipelineProjectTotalOffshore(currentEmpList));
		summary.setTotalOnsite(  getPipelineProjectTotalOnsite(currentEmpList));
		summary.setTotalAllocated ( summary.getTotalOffshore() + summary.getTotalOnsite());
		summary.setUnbilledOffshore ( getPipelineProjectUnbilledOffshore(currentEmpList));
		summary.setUnbilledOnsite ( getPipelineProjectUnbilledOnsite(currentEmpList));
		summary.setDoNOTBILL ( getPipelineProjectDoNOTBILL(currentEmpList));
		summary.setTotalUnbilled( summary.getUnbilledOffshore() + summary.getUnbilledOnsite());
		summary.setBilledOffshore ( getPipelineProjectBilledOffshore(currentEmpList));
		summary.setBilledOnsite ( getPipelineProjectBilledOnsite(currentEmpList));
		summary.setTotalBilled(  summary.getBilledOffshore() + summary.getBilledOnsite());
		summaryList.add(summary);
		summary = new SummaryRow();
		
		// Management Project
		summary.setColumnRowName("Management Project");
		summary.setTotalOffshore ( getManagementProjectTotalOffshore(currentEmpList));
		summary.setTotalOnsite(  getManagementProjectTotalOnsite(currentEmpList));
		summary.setTotalAllocated ( summary.getTotalOffshore() + summary.getTotalOnsite());
		summary.setUnbilledOffshore ( getManagementProjectUnbilledOffshore(currentEmpList));
		summary.setUnbilledOnsite ( getManagementProjectUnbilledOnsite(currentEmpList));
		summary.setDoNOTBILL ( getManagementProjectDoNOTBILL(currentEmpList));
		summary.setTotalUnbilled( summary.getUnbilledOffshore() + summary.getUnbilledOnsite());
		summary.setBilledOffshore ( getManagementProjectBilledOffshore(currentEmpList));
		summary.setBilledOnsite ( getManagementProjectBilledOnsite(currentEmpList));
		summary.setTotalBilled(  summary.getBilledOffshore() + summary.getBilledOnsite());

		// Non Delivery Sub Total
		summary.setColumnRowName("Non Delivery Sub Total");
		summary.setTotalOffshore ( summary.getTotalOffshore() + summary.getTotalOffshore() + summary.getTotalOffshore() + summary.getTotalOffshore() + summary.getTotalOffshore());
		summary.setTotalOnsite(  summary.getTotalOnsite() + summary.getTotalOnsite() + summary.getTotalOnsite() + summary.getTotalOnsite() + summary.getTotalOnsite());
		summary.setTotalAllocated ( summary.getTotalAllocated() + summary.getTotalAllocated() + summary.getTotalAllocated() + summary.getTotalAllocated() + summary.getTotalAllocated());
		summary.setUnbilledOffshore ( summary.getUnbilledOffshore() + summary.getUnbilledOffshore() + summary.getUnbilledOffshore() + summary.getUnbilledOffshore() + summary.getUnbilledOffshore());
		summary.setUnbilledOnsite ( summary.getUnbilledOnsite() + summary.getUnbilledOnsite() + summary.getUnbilledOnsite() + summary.getUnbilledOnsite() + summary.getUnbilledOnsite());
		summary.setDoNOTBILL ( summary.getDoNOTBILL() + summary.getDoNOTBILL() + summary.getDoNOTBILL() + summary.getDoNOTBILL() + summary.getDoNOTBILL());
		summary.setTotalUnbilled( summary.getTotalUnbilled()+ summary.getTotalUnbilled()+ summary.getTotalUnbilled()+ summary.getTotalUnbilled()+ summary.getTotalUnbilled());
		summary.setBilledOffshore ( summary.getBilledOffshore() + summary.getBilledOffshore() + summary.getBilledOffshore() + summary.getBilledOffshore() + summary.getBilledOffshore());
		summary.setBilledOnsite ( summary.getBilledOnsite() + summary.getBilledOnsite() + summary.getBilledOnsite() + summary.getBilledOnsite() + summary.getBilledOnsite());
		summary.setTotalBilled(  summary.getTotalBilled() + summary.getTotalBilled() + summary.getTotalBilled() + summary.getTotalBilled() + summary.getTotalBilled());
		summaryList.add(summary);
		summary = new SummaryRow();
		
		// Buffer
		summary.setColumnRowName("Buffer");
		summary.setTotalOffshore ( getBufferTotalOffshore(currentEmpList));
		summary.setTotalOnsite(  getBufferTotalOnsite(currentEmpList));
		summary.setTotalAllocated ( summary.getTotalOffshore() + summary.getTotalOnsite());
		summary.setUnbilledOffshore ( getBufferUnbilledOffshore(currentEmpList));
		summary.setUnbilledOnsite ( getBufferUnbilledOnsite(currentEmpList));
		summary.setDoNOTBILL ( getBufferDoNOTBILL(currentEmpList));
		summary.setTotalUnbilled( summary.getUnbilledOffshore() + summary.getUnbilledOnsite());
		summary.setBilledOffshore ( getBufferBilledOffshore(currentEmpList));
		summary.setBilledOnsite ( getBufferBilledOnsite(currentEmpList));
		summary.setTotalBilled( summary.getBilledOffshore() + summary.getBilledOnsite());
		
		summaryList.add(summary);
		
		return summaryList;
		
	}

	private int getBufferBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getBufferUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getBufferTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Buffer") && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) {
	        	temp ++;
	        }
		}
		return temp;
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////

	private int getManagementProjectBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getManagementProjectUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getManagementProjectTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Management") && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) {
	        	temp ++;
	        }
		}
		return temp;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getPipelineProjectBilledOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getPipelineProjectBilledOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getPipelineProjectDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getPipelineProjectUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getPipelineProjectUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getPipelineProjectTotalOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getPipelineProjectTotalOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getOtherInvestmentBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
				return 0;
	}

	private int getOtherInvestmentUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getOtherInvestmentTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_TYPE().equalsIgnoreCase("Investment") && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) {
	        	temp ++;
	        }
		}
		return temp;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getMENoPOAmericasBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_NO_PO_America_WD") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_NO_PO_America_WD") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getMENoPOAmericasUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if((ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_NO_PO_America_WD")) && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_NO_PO_America_WD") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_NO_PO_America_WD") && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getMENoPOAmericasTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_NO_PO_America_WD")) {
	        	temp ++;
	        }
		}
		return temp;
		
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getDeliveryWDBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_Delivery_WD") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_Delivery_WD") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryWDUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_Delivery_WD") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_Delivery_WD") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_Delivery_WD") && ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryWDTotalOnsite(List<CurrentEmployee> currentEmpList) {
		 
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getPROJECT_DESCRIPTION().equalsIgnoreCase("ME_Delivery_WD") && ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE")) {
	        	temp ++;
	        }
		}
		return temp;
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getDeliverywithoutPOBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPO_FLAG().equalsIgnoreCase("N")&& ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPOBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPO_FLAG().equalsIgnoreCase("N") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPODoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliverywithoutPOUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPO_FLAG().equalsIgnoreCase("N")&& !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPOUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPO_FLAG().equalsIgnoreCase("N") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPOTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPO_FLAG().equalsIgnoreCase("N")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliverywithoutPOTotalOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPO_FLAG().equalsIgnoreCase("N")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPOBilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPO_FLAG().equalsIgnoreCase("Y")&& ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPOBilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPO_FLAG().equalsIgnoreCase("Y") && ce.isBILLABLITY_STATUS()) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPODoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryProjectswithPOUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPO_FLAG().equalsIgnoreCase("Y")&& !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPOUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPO_FLAG().equalsIgnoreCase("Y") && !(ce.isBILLABLITY_STATUS())) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPOTotalOnsite(List<CurrentEmployee> currentEmpList) {
		
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("ONSITE") && ce.getPO_FLAG().equalsIgnoreCase("Y")) {
	        	temp ++;
	        }
		}
		return temp;
	}

	private int getDeliveryProjectswithPOTotalOffshore(List<CurrentEmployee> currentEmpList) {
		int temp = 0;
		for(CurrentEmployee ce : currentEmpList) {
			
	        if(ce.getONSITE_OFFSHORE().equalsIgnoreCase("OFFSHORE") && ce.getPO_FLAG().equalsIgnoreCase("Y")) {
	        	temp ++;
	        }
		}
		return temp;
	}
}
