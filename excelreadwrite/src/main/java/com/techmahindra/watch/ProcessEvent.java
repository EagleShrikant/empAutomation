package com.techmahindra.watch;

import org.springframework.stereotype.Component;

@Component
public interface ProcessEvent {
	
	public boolean process();
	
}
