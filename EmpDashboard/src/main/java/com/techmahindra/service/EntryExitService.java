package com.techmahindra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmahindra.model.EntryExitModel;
import com.techmahindra.model.SummaryModel;

@RestController
public class EntryExitService {

	@Autowired
	EntryExitModel entryExitModel;
	
	@CrossOrigin
	@GetMapping("/getEntryExitData")
	public EntryExitModel getSummaryModel() {
		System.out.println("getEntryExitData");
		
		return entryExitModel;
	}
	
}
