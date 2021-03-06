package com.unla.UnlaLybrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.UnlaLybrary.models.UniversityModel;
import com.unla.UnlaLybrary.service.ICareerService;
import com.unla.UnlaLybrary.service.IUniversityService;
import com.unla.UnlaLybrary.helpers.ViewRouteHelper;


@Controller
@RequestMapping("/university")
public class UniversityController {
	
	@Autowired
	@Qualifier("universityService")
	private IUniversityService universityService;
	
	@Autowired
	@Qualifier("careerService")
	private ICareerService careerService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UNIVERSITY_INDEX);
		mAV.addObject("universities", universityService.getAlls());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UNIVERSITY_NEW);
		mAV.addObject("university", new UniversityModel());
		mAV.addObject("careers",careerService.getAlls());
		return mAV;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("university") UniversityModel universityModel) {
		universityService.insert(universityModel);
		return new RedirectView(ViewRouteHelper.UNIVERSITY_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.UNIVERSITY_UPDATE);
		mAV.addObject("university", universityService.findById(id));
		mAV.addObject("careers", careerService.findByIdUniversity(id));
		return mAV;
	}
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("university") UniversityModel universityModel) {
		universityService.update(universityModel);
		return new RedirectView(ViewRouteHelper.UNIVERSITY_ROOT);
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		universityService.remove(id);
		return new RedirectView(ViewRouteHelper.UNIVERSITY_ROOT);
	}
	

}
