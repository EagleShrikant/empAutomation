package com.techmahindra.watch;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FolderScan {

	public void watchFolderEvent(String watchingSourceFolder, String watchingDestinationFolder,
			ProcessEvent processEvent) throws InterruptedException, IOException {
		Path faxFolder = Paths.get(watchingSourceFolder);
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		WatchService watchService = FileSystems.getDefault().newWatchService();
		faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

		boolean valid = true;
		do {
			WatchKey watchKey = watchService.take();

			for (WatchEvent<?> event : watchKey.pollEvents()) {
				//WatchEvent.Kind<?> kind = event.kind();
				if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
					String fileName = event.context().toString();
					//System.out.println("File Created:" + fileName);
					processEvent.process();
					File file1 = new File(watchingSourceFolder+"/"+fileName);
					SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");  
				    Date date = new Date();
					File file2 = new File(watchingDestinationFolder+"/"+formatter.format(date));
					System.out.println( file1.renameTo(file2) );
				}
			}
			valid = watchKey.reset();

		} while (valid);
	}
	
}
