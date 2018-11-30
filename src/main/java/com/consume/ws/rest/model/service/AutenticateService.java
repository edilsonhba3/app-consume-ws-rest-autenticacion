package com.consume.ws.rest.model.service;

import com.consume.ws.rest.model.dto.ObjectResponse;

public interface AutenticateService 
{
	public ObjectResponse autenticate(String email, String password);
}
