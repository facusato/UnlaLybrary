package com.unla.UnlaLybrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.UnlaLybrary.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mV= new ModelAndView(ViewRouteHelper.CONTACT_INDEX);
		return mV;
	}
	
}