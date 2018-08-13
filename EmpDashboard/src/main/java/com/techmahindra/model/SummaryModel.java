package com.techmahindra.model;

import java.util.List;

import com.techmahindra.dao.CurrentEmployee;

public class SummaryModel {
	
	int[][] summary = new int[10][10];

	public int[][] getSummaryTable() {
		return summary;
	}
	
	public int[][] setSummaryTable(List<CurrentEmployee> currentEmpList) {
				
		// Delivery Projects with PO
		summary[0][0] = getDeliveryProjectswithPOTotalOnsite(currentEmpList);
		summary[0][1] = getDeliveryProjectswithPOTotalOffshore(currentEmpList);
		summary[0][2] = summary[0][0] + summary[0][1];
		summary[0][3] = getDeliveryProjectswithPOUnbilledOffshore(currentEmpList);
		summary[0][4] = getDeliveryProjectswithPOUnbilledOnsite(currentEmpList);
		summary[0][5] = getDeliveryProjectswithPODoNOTBILL(currentEmpList);
		summary[0][6] = summary[0][3] + summary[0][4];
		summary[0][7] = getDeliveryProjectswithPOBilledOffshore();
		summary[0][8] = getDeliveryProjectswithPOBilledOnsite();
		summary[0][9] = summary[0][7] + summary[0][8];

		// Delivery without PO
		summary[1][0] = getDeliverywithoutPOTotalOnsite(currentEmpList);
		summary[1][1] = getDeliverywithoutPOTotalOffshore(currentEmpList);
		summary[1][2] = summary[0][0] + summary[0][1];
		summary[1][3] = getDeliverywithoutPOUnbilledOffshore(currentEmpList);
		summary[1][4] = getDeliverywithoutPOUnbilledOnsite(currentEmpList);
		summary[1][5] = getDeliverywithoutPODoNOTBILL(currentEmpList);
		summary[1][6] = summary[0][3] + summary[0][4];
		summary[1][7] = getDeliverywithoutPOBilledOffshore();
		summary[1][8] = getDeliverywithoutPOBilledOnsite();
		summary[1][9] = summary[0][7] + summary[0][8];

		// Delivery Total
		summary[2][0] = summary[0][0] + summary[1][0];
		summary[2][1] = summary[0][1] + summary[1][1];
		summary[2][2] = summary[0][2] + summary[1][2];
		summary[2][3] = summary[0][3] + summary[1][3];
		summary[2][4] = summary[0][4] + summary[1][4];
		summary[2][5] = summary[0][5] + summary[1][5];
		summary[2][6] = summary[0][6] + summary[1][6];
		summary[2][7] = summary[0][7] + summary[1][7];
		summary[2][8] = summary[0][8] + summary[1][8];
		summary[2][9] = summary[0][9] + summary[1][9];

		// Delivery WD
		summary[3][0] = getDeliveryWDTotalOnsite(currentEmpList);
		summary[3][1] = getDeliveryWDTotalOffshore(currentEmpList);
		summary[3][2] = summary[3][0] + summary[3][1];
		summary[3][3] = getDeliveryWDUnbilledOffshore(currentEmpList);
		summary[3][4] = getDeliveryWDUnbilledOnsite(currentEmpList);
		summary[3][5] = getDeliveryWDDoNOTBILL(currentEmpList);
		summary[3][6] = summary[3][3] + summary[3][4];
		summary[3][7] = getDeliveryWDBilledOffshore();
		summary[3][8] = getDeliveryWDBilledOnsite();
		summary[3][9] = summary[3][7] + summary[3][8];

		// ME No PO Americas
		summary[4][0] = getMENoPOAmericasTotalOnsite(currentEmpList);
		summary[4][1] = getMENoPOAmericasTotalOffshore(currentEmpList);
		summary[4][2] = summary[4][0] + summary[4][1];
		summary[4][3] = getMENoPOAmericasUnbilledOffshore(currentEmpList);
		summary[4][4] = getMENoPOAmericasUnbilledOnsite(currentEmpList);
		summary[4][5] = getMENoPOAmericasDoNOTBILL(currentEmpList);
		summary[4][6] = summary[4][3] + summary[4][4];
		summary[4][7] = getMENoPOAmericasBilledOffshore();
		summary[4][8] = getMENoPOAmericasBilledOnsite();
		summary[4][9] = summary[4][7] + summary[4][8];
		
		// Other Investment
		summary[5][0] = getOtherInvestmentTotalOnsite(currentEmpList);
		summary[5][1] = getOtherInvestmentTotalOffshore(currentEmpList);
		summary[5][2] = summary[5][0] + summary[5][1];
		summary[5][3] = getOtherInvestmentUnbilledOffshore(currentEmpList);
		summary[5][4] = getOtherInvestmentUnbilledOnsite(currentEmpList);
		summary[5][5] = getOtherInvestmentDoNOTBILL(currentEmpList);
		summary[5][6] = summary[5][3] + summary[5][4];
		summary[5][7] = getOtherInvestmentBilledOffshore();
		summary[5][8] = getOtherInvestmentBilledOnsite();
		summary[5][9] = summary[5][7] + summary[5][8];
		
		// Pipeline Project
		summary[6][0] = getPipelineProjectTotalOnsite(currentEmpList);
		summary[6][1] = getPipelineProjectTotalOffshore(currentEmpList);
		summary[6][2] = summary[6][0] + summary[6][1];
		summary[6][3] = getPipelineProjectUnbilledOffshore(currentEmpList);
		summary[6][4] = getPipelineProjectUnbilledOnsite(currentEmpList);
		summary[6][5] = getPipelineProjectDoNOTBILL(currentEmpList);
		summary[6][6] = summary[6][3] + summary[6][4];
		summary[6][7] = getPipelineProjectBilledOffshore();
		summary[6][8] = getPipelineProjectBilledOnsite();
		summary[6][9] = summary[6][7] + summary[6][8];
		
		// Management Project
		summary[7][0] = getManagementProjectTotalOnsite(currentEmpList);
		summary[7][1] = getManagementProjectTotalOffshore(currentEmpList);
		summary[7][2] = summary[7][0] + summary[7][1];
		summary[7][3] = getManagementProjectUnbilledOffshore(currentEmpList);
		summary[7][4] = getManagementProjectUnbilledOnsite(currentEmpList);
		summary[7][5] = getManagementProjectDoNOTBILL(currentEmpList);
		summary[7][6] = summary[7][3] + summary[7][4];
		summary[7][7] = getManagementProjectBilledOffshore();
		summary[7][8] = getManagementProjectBilledOnsite();
		summary[7][9] = summary[7][7] + summary[7][8];

		// Non Delivery Sub Total
		summary[8][0] = summary[3][0] + summary[4][0] + summary[5][0] + summary[6][0] + summary[7][0];
		summary[8][1] = summary[3][1] + summary[4][1] + summary[5][1] + summary[6][1] + summary[7][1];
		summary[8][2] = summary[3][2] + summary[4][2] + summary[5][2] + summary[6][2] + summary[7][2];
		summary[8][3] = summary[3][3] + summary[4][3] + summary[5][3] + summary[6][3] + summary[7][3];
		summary[8][4] = summary[3][4] + summary[4][4] + summary[5][4] + summary[6][4] + summary[7][4];
		summary[8][5] = summary[3][5] + summary[4][5] + summary[5][5] + summary[6][5] + summary[7][5];
		summary[8][6] = summary[3][6] + summary[4][6] + summary[5][6] + summary[6][6] + summary[7][6];
		summary[8][7] = summary[3][7] + summary[4][7] + summary[5][7] + summary[6][7] + summary[7][7];
		summary[8][8] = summary[3][8] + summary[4][8] + summary[5][8] + summary[6][8] + summary[7][8];
		summary[8][9] = summary[3][9] + summary[4][9] + summary[5][9] + summary[6][9] + summary[7][9];

		// Buffer
		summary[9][0] = getBufferTotalOnsite(currentEmpList);
		summary[9][1] = getBufferTotalOffshore(currentEmpList);
		summary[9][2] = summary[9][0] + summary[9][1];
		summary[9][3] = getBufferUnbilledOffshore(currentEmpList);
		summary[9][4] = getBufferUnbilledOnsite(currentEmpList);
		summary[9][5] = getBufferDoNOTBILL(currentEmpList);
		summary[9][6] = summary[9][3] + summary[9][4];
		summary[9][7] = getBufferBilledOffshore();
		summary[9][8] = getBufferBilledOnsite();
		summary[9][9] = summary[9][7] + summary[9][8];
		return summary;
		
	}

	private int getBufferBilledOnsite() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getBufferBilledOffshore() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getBufferDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getBufferUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getBufferUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getBufferTotalOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getBufferTotalOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getManagementProjectBilledOnsite() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getManagementProjectBilledOffshore() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getManagementProjectDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getManagementProjectUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getManagementProjectUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getManagementProjectTotalOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getManagementProjectTotalOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getPipelineProjectBilledOnsite() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getPipelineProjectBilledOffshore() {
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

	private int getOtherInvestmentBilledOnsite() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getOtherInvestmentBilledOffshore() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getOtherInvestmentDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getOtherInvestmentUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getOtherInvestmentUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getOtherInvestmentTotalOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getOtherInvestmentTotalOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getMENoPOAmericasBilledOnsite() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getMENoPOAmericasBilledOffshore() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getMENoPOAmericasDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getMENoPOAmericasUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getMENoPOAmericasUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getMENoPOAmericasTotalOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getMENoPOAmericasTotalOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryWDBilledOnsite() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryWDBilledOffshore() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryWDDoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryWDUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryWDUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryWDTotalOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryWDTotalOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliverywithoutPOBilledOnsite() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliverywithoutPOBilledOffshore() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliverywithoutPODoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliverywithoutPOUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliverywithoutPOUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliverywithoutPOTotalOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliverywithoutPOTotalOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryProjectswithPOBilledOnsite() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryProjectswithPOBilledOffshore() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryProjectswithPODoNOTBILL(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryProjectswithPOUnbilledOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryProjectswithPOUnbilledOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryProjectswithPOTotalOnsite(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDeliveryProjectswithPOTotalOffshore(List<CurrentEmployee> currentEmpList) {
		// TODO Auto-generated method stub
		return 0;
	}
}
