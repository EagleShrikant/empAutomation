package com.techmahindra.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.techmahindra.extraction.DataExtraction;
import com.techmahindra.watch.FolderScan;
import com.techmahindra.watch.ProcessEvent;

@Component
public class WatchFolder implements ProcessEvent {

	
	@Autowired
	FolderScan folderScan;
	
	@Autowired
	DataExtraction dataExtraction;
	
	@Override
	public boolean process(String fileName) {
		
		try {
				
		dataExtraction.process(fileName);
		
		return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
