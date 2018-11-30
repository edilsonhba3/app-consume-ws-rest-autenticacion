package com.consume.ws.rest.model.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.consume.ws.rest.model.dto.ObjectResponse;
import com.consume.ws.rest.util.PropertiesUtil;

@Service
public class AutenticateServiceImpl implements AutenticateService
{	
	private RestTemplate restTemplate   = new RestTemplate();
	private final String authUrl = PropertiesUtil.DOMAIN_URL + "/autentication";

	@Override
	public ObjectResponse autenticate(String email, String password) 
	{
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		map.add("email", email);
		map.add("pass", password);
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);				
		ResponseEntity<ObjectResponse> response = restTemplate.postForEntity(authUrl, request , ObjectResponse.class);		
		return response.getBody();
	}
}
