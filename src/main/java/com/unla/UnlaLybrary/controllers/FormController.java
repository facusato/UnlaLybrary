package com.unla.UnlaLybrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.UnlaLybrary.helpers.ViewRouteHelper;
import com.unla.UnlaLybrary.services.implementation.MailService;

@Controller
@RequestMapping("/form")
public class FormController {
	
	
	 @Autowired
	 private MailService mailService;
	 
	 @GetMapping("")
		public ModelAndView index() {
			ModelAndView mV= new ModelAndView(ViewRouteHelper.FORM_INDEX);
			return mV;
		}
	
	
	 @PostMapping("/sendMail")
	    public ModelAndView sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body){

	        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
	        mailService.sendMail("proyectosoftwarecontacto@gmail.com","proyectosoftwarecontacto@gmail.com",subject,message);
	        ModelAndView mV= new ModelAndView(ViewRouteHelper.FORM_INDEX);
	        return mV;
	    }
	
	
}