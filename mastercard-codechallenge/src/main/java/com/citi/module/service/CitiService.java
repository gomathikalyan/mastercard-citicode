package com.citi.module.service;

import org.springframework.stereotype.Service;

@Service
public interface CitiService {
	
	public String verifyCitiesConnected(String origin, String destination);
	
}
