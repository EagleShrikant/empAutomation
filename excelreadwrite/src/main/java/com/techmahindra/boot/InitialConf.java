package com.techmahindra.boot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.techmahindra.watch.FolderScan;

@Component
public class InitialConf {

	@Autowired
	FolderScan folderScan;
	
	@Autowired
	WatchFolder watchFolder;
	
	@Value("${scanning.folder}")
    String scan_source_folder_path;
	
	@Value("${backup.folder}")
    String scan_destination_folder_path;
	
	public void init() {
		try {
			System.out.println("Init : Start");
			folderScan.watchFolderEvent(scan_source_folder_path , scan_destination_folder_path, watchFolder);
			System.out.println("Init : End");
		} catch (InterruptedException | IOException e) {
			
			e.printStackTrace();
		}
	}
	

	
}
