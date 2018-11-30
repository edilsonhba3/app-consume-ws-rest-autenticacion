package com.consume.ws.rest.model.dto;

import lombok.Data;

@Data
public class ObjectResponse 
{
	private String code;
	
	private String status;
	
	private Object response;
}
