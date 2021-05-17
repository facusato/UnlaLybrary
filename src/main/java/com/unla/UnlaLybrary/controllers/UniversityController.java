package com.unla.UnlaLybrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.UnlaLybrary.models.UniversityModel;
import com.unla.UnlaLybrary.service.IUniversityService;
import com.unla.UnlaLybrary.helpers.ViewRouteHelper;


@Controller
@RequestMapping("/university")
public class UniversityController {
	
	@Autowired
	@Qualifier("universityService")
	private IUniversityService universityService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UNIVERSITY_INDEX);
		mAV.addObject("universities", universityService.getAlls());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UNIVERSITY_NEW);
		mAV.addObject("university", new UniversityModel());
		return mAV;
	}
	
	
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("university") UniversityModel universityModel) {
		universityService.insertOrUpdate(universityModel);
		return new RedirectView(ViewRouteHelper.UNIVERSITY_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UNIVERSITY_UPDATE);
		mAV.addObject("university", universityService.findById(id));
		return mAV;
	}
	

	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("university") UniversityModel universityModel) {
		universityService.insertOrUpdate(universityModel);
		return new RedirectView(ViewRouteHelper.UNIVERSITY_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		universityService.remove(id);
		return new RedirectView(ViewRouteHelper.UNIVERSITY_ROOT);
	}
	

}
