package com.techmahindra.model;

import org.springframework.stereotype.Component;

@Component
public class BillableModel {
	int previousDeliveryWD = 0;
	int previousMENoPOAmericas = 0;
	int previousOtherInvestmentHeadcount = 0;
	int previousManagementPipelineProject = 0;
	int previousBufferHeadcount = 0;
	int previousUnbilledCustomerDelivery = 0;
	int previousDeliveryBilledHeadcount = 0;
	int previousRevisedDeliveryTotalHeadcount = 0;
	int previousRevisedNonDeliveryPlusBufferTotal = 0;

	int increaseInBillingDeliveryWD = 0;
	int increaseInBillingMENoPOAmericas = 0;
	int increaseInBillingOtherInvestmentHeadcount = 0;
	int increaseInBillingManagementPipelineProject = 0;
	int increaseInBillingBufferHeadcount = 0;
	int increaseInBillingUnbilledCustomerDelivery = 0;
	int increaseInBillingDeliveryBilledHeadcount = 0;
	int increaseInBillingRevisedDeliveryTotalHeadcount = 0;
	int increaseInBillingRevisedNonDeliveryPlusBufferTotal = 0;	

	int exitDeliveryWD = 0;
	int exitMENoPOAmericas = 0;
	int exitOtherInvestmentHeadcount = 0;
	int exitManagementPipelineProject = 0;
	int exitBufferHeadcount = 0;
	int exitUnbilledCustomerDelivery = 0;
	int exitDeliveryBilledHeadcount = 0;
	int exitRevisedDeliveryTotalHeadcount = 0;
	int exitRevisedNonDeliveryPlusBufferTotal = 0;
	
	
	public int getPreviousDeliveryWD() {
		return previousDeliveryWD;
	}
	public void setPreviousDeliveryWD(int previousDeliveryWD) {
		this.previousDeliveryWD = previousDeliveryWD;
	}
	public int getPreviousMENoPOAmericas() {
		return previousMENoPOAmericas;
	}
	public void setPreviousMENoPOAmericas(int previousMENoPOAmericas) {
		this.previousMENoPOAmericas = previousMENoPOAmericas;
	}
	public int getPreviousOtherInvestmentHeadcount() {
		return previousOtherInvestmentHeadcount;
	}
	public void setPreviousOtherInvestmentHeadcount(int previousOtherInvestmentHeadcount) {
		this.previousOtherInvestmentHeadcount = previousOtherInvestmentHeadcount;
	}
	public int getPreviousManagementPipelineProject() {
		return previousManagementPipelineProject;
	}
	public void setPreviousManagementPipelineProject(int previousManagementPipelineProject) {
		this.previousManagementPipelineProject = previousManagementPipelineProject;
	}
	public int getPreviousBufferHeadcount() {
		return previousBufferHeadcount;
	}
	public void setPreviousBufferHeadcount(int previousBufferHeadcount) {
		this.previousBufferHeadcount = previousBufferHeadcount;
	}
	public int getPreviousUnbilledCustomerDelivery() {
		return previousUnbilledCustomerDelivery;
	}
	public void setPreviousUnbilledCustomerDelivery(int previousUnbilledCustomerDelivery) {
		this.previousUnbilledCustomerDelivery = previousUnbilledCustomerDelivery;
	}
	public int getPreviousDeliveryBilledHeadcount() {
		return previousDeliveryBilledHeadcount;
	}
	public void setPreviousDeliveryBilledHeadcount(int previousDeliveryBilledHeadcount) {
		this.previousDeliveryBilledHeadcount = previousDeliveryBilledHeadcount;
	}
	public int getPreviousRevisedDeliveryTotalHeadcount() {
		return previousRevisedDeliveryTotalHeadcount;
	}
	public void setPreviousRevisedDeliveryTotalHeadcount(int previousRevisedDeliveryTotalHeadcount) {
		this.previousRevisedDeliveryTotalHeadcount = previousRevisedDeliveryTotalHeadcount;
	}
	public int getPreviousRevisedNonDeliveryPlusBufferTotal() {
		return previousRevisedNonDeliveryPlusBufferTotal;
	}
	public void setPreviousRevisedNonDeliveryPlusBufferTotal(int previousRevisedNonDeliveryPlusBufferTotal) {
		this.previousRevisedNonDeliveryPlusBufferTotal = previousRevisedNonDeliveryPlusBufferTotal;
	}
	public int getIncreaseInBillingDeliveryWD() {
		return increaseInBillingDeliveryWD;
	}
	public void setIncreaseInBillingDeliveryWD(int increaseInBillingDeliveryWD) {
		this.increaseInBillingDeliveryWD = increaseInBillingDeliveryWD;
	}
	public int getIncreaseInBillingMENoPOAmericas() {
		return increaseInBillingMENoPOAmericas;
	}
	public void setIncreaseInBillingMENoPOAmericas(int increaseInBillingMENoPOAmericas) {
		this.increaseInBillingMENoPOAmericas = increaseInBillingMENoPOAmericas;
	}
	public int getIncreaseInBillingOtherInvestmentHeadcount() {
		return increaseInBillingOtherInvestmentHeadcount;
	}
	public void setIncreaseInBillingOtherInvestmentHeadcount(int increaseInBillingOtherInvestmentHeadcount) {
		this.increaseInBillingOtherInvestmentHeadcount = increaseInBillingOtherInvestmentHeadcount;
	}
	public int getIncreaseInBillingManagementPipelineProject() {
		return increaseInBillingManagementPipelineProject;
	}
	public void setIncreaseInBillingManagementPipelineProject(int increaseInBillingManagementPipelineProject) {
		this.increaseInBillingManagementPipelineProject = increaseInBillingManagementPipelineProject;
	}
	public int getIncreaseInBillingBufferHeadcount() {
		return increaseInBillingBufferHeadcount;
	}
	public void setIncreaseInBillingBufferHeadcount(int increaseInBillingBufferHeadcount) {
		this.increaseInBillingBufferHeadcount = increaseInBillingBufferHeadcount;
	}
	public int getIncreaseInBillingUnbilledCustomerDelivery() {
		return increaseInBillingUnbilledCustomerDelivery;
	}
	public void setIncreaseInBillingUnbilledCustomerDelivery(int increaseInBillingUnbilledCustomerDelivery) {
		this.increaseInBillingUnbilledCustomerDelivery = increaseInBillingUnbilledCustomerDelivery;
	}
	public int getIncreaseInBillingDeliveryBilledHeadcount() {
		return increaseInBillingDeliveryBilledHeadcount;
	}
	public void setIncreaseInBillingDeliveryBilledHeadcount(int increaseInBillingDeliveryBilledHeadcount) {
		this.increaseInBillingDeliveryBilledHeadcount = increaseInBillingDeliveryBilledHeadcount;
	}
	public int getIncreaseInBillingRevisedDeliveryTotalHeadcount() {
		return increaseInBillingRevisedDeliveryTotalHeadcount;
	}
	public void setIncreaseInBillingRevisedDeliveryTotalHeadcount(int increaseInBillingRevisedDeliveryTotalHeadcount) {
		this.increaseInBillingRevisedDeliveryTotalHeadcount = increaseInBillingRevisedDeliveryTotalHeadcount;
	}
	public int getIncreaseInBillingRevisedNonDeliveryPlusBufferTotal() {
		return increaseInBillingRevisedNonDeliveryPlusBufferTotal;
	}
	public void setIncreaseInBillingRevisedNonDeliveryPlusBufferTotal(
			int increaseInBillingRevisedNonDeliveryPlusBufferTotal) {
		this.increaseInBillingRevisedNonDeliveryPlusBufferTotal = increaseInBillingRevisedNonDeliveryPlusBufferTotal;
	}
	public int getExitDeliveryWD() {
		return exitDeliveryWD;
	}
	public void setExitDeliveryWD(int exitDeliveryWD) {
		this.exitDeliveryWD = exitDeliveryWD;
	}
	public int getExitMENoPOAmericas() {
		return exitMENoPOAmericas;
	}
	public void setExitMENoPOAmericas(int exitMENoPOAmericas) {
		this.exitMENoPOAmericas = exitMENoPOAmericas;
	}
	public int getExitOtherInvestmentHeadcount() {
		return exitOtherInvestmentHeadcount;
	}
	public void setExitOtherInvestmentHeadcount(int exitOtherInvestmentHeadcount) {
		this.exitOtherInvestmentHeadcount = exitOtherInvestmentHeadcount;
	}
	public int getExitManagementPipelineProject() {
		return exitManagementPipelineProject;
	}
	public void setExitManagementPipelineProject(int exitManagementPipelineProject) {
		this.exitManagementPipelineProject = exitManagementPipelineProject;
	}
	public int getExitBufferHeadcount() {
		return exitBufferHeadcount;
	}
	public void setExitBufferHeadcount(int exitBufferHeadcount) {
		this.exitBufferHeadcount = exitBufferHeadcount;
	}
	public int getExitUnbilledCustomerDelivery() {
		return exitUnbilledCustomerDelivery;
	}
	public void setExitUnbilledCustomerDelivery(int exitUnbilledCustomerDelivery) {
		this.exitUnbilledCustomerDelivery = exitUnbilledCustomerDelivery;
	}
	public int getExitDeliveryBilledHeadcount() {
		return exitDeliveryBilledHeadcount;
	}
	public void setExitDeliveryBilledHeadcount(int exitDeliveryBilledHeadcount) {
		this.exitDeliveryBilledHeadcount = exitDeliveryBilledHeadcount;
	}
	public int getExitRevisedDeliveryTotalHeadcount() {
		return exitRevisedDeliveryTotalHeadcount;
	}
	public void setExitRevisedDeliveryTotalHeadcount(int exitRevisedDeliveryTotalHeadcount) {
		this.exitRevisedDeliveryTotalHeadcount = exitRevisedDeliveryTotalHeadcount;
	}
	public int getExitRevisedNonDeliveryPlusBufferTotal() {
		return exitRevisedNonDeliveryPlusBufferTotal;
	}
	public void setExitRevisedNonDeliveryPlusBufferTotal(int exitRevisedNonDeliveryPlusBufferTotal) {
		this.exitRevisedNonDeliveryPlusBufferTotal = exitRevisedNonDeliveryPlusBufferTotal;
	}

	
}
