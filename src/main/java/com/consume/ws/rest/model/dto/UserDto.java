
package com.consume.ws.rest.model.dto;

import lombok.Data;

@Data
public class UserDto 
{
    private Integer pk;
    
    private String email;
    
    private String password;
    
    private String name;
    
    private String lastName;
    
    private String active;
}
