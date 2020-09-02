package com.citi.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citi.module.service.CitiService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CitiController {
	
	@Autowired
	CitiService citiService;
	
	@ApiOperation(
	        value = "This method used to check whether given 2 cities has connected with road ",
	        notes = "")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Yes. The given cities are connected with road. "),
	        @ApiResponse(code = 404, message = "No. The given cities are not connected with road.")})
	@GetMapping("/connected")
	public ResponseEntity<String> getCitiConnection(@RequestParam String origin, @RequestParam String destination) {
		System.out.println("Searching by Origin  : " + origin + " destination : " + destination);
		String result = citiService.getCitiDetails(origin, destination);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
