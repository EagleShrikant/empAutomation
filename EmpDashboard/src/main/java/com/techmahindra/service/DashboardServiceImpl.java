package com.techmahindra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmahindra.model.BillableModel;
import com.techmahindra.model.SummaryModel;


@RestController
public class DashboardServiceImpl {

	@Autowired
	SummaryModel summaryModel;
	
	@Autowired
	BillableModel billableModel;
	
	@GetMapping("/getSummaryData")
	public SummaryModel getSummaryModel() {
		System.out.println("getSummaryData");
		return summaryModel;
	}
	
	@GetMapping("/getBillableData")
	public BillableModel getBillableModel() {
		System.out.println("getBillableData");
		return billableModel;
	}
}
