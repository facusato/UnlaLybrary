package com.unla.UnlaLybrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.UnlaLybrary.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mV= new ModelAndView(ViewRouteHelper.HOME_INDEX);
		return mV;
	}
	
}