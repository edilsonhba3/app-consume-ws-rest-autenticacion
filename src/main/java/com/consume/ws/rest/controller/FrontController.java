package com.consume.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.consume.ws.rest.model.dto.ObjectResponse;
import com.consume.ws.rest.model.service.AutenticateService;
import com.consume.ws.rest.util.PropertiesUtil;

@Controller
@RequestMapping("/")
public class FrontController 
{
	@Autowired
	private AutenticateService autenticateService;
	
	@GetMapping({"/", "/home"})
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView();        
        mav.setViewName("home");
        return mav;
    }
	
	@PostMapping("/autenticar")
    public ModelAndView autenticate(@RequestParam String email, @RequestParam String pass)
    {
        ModelAndView mav = new ModelAndView(); 
        ObjectResponse response = autenticateService.autenticate(email, pass);
        
        if (response.getCode().equals(PropertiesUtil.CODE_SUCCESS)) 
        {
        	mav.addObject(PropertiesUtil.MESSAGE, "Bienvenido "+ response.getResponse());
        	mav.setViewName("inicio");	
        }
        else
        {
        	mav.addObject(PropertiesUtil.MESSAGE, "error "+ response.getResponse());
        	mav.setViewName("error");
        }
        return mav;
    }
}
