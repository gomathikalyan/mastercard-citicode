package com.citi.module.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.citi.module.util.CitiConstants;

@Service
public class CitiService {

	public String getCitiDetails(String origin, String destination) {
		String connected = CitiConstants.NO;
		Path filePath = Paths.get("C:\\Gomathi\\WorkSpace\\HandsOn\\mastercard-codechallenge", "citi.txt");

		try (Stream<String> lines = Files.lines(filePath) ) {

			Optional<String> s1 = lines.filter(s -> s.contains(origin) && s.contains(destination)).peek(System.out::println).findFirst();
		
			return s1.isPresent() ? CitiConstants.YES : CitiConstants.NO;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connected;
	}
}
