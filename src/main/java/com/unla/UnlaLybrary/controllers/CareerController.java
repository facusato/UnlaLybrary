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
import com.unla.UnlaLybrary.helpers.ViewRouteHelper;
import com.unla.UnlaLybrary.models.CareerModel;
import com.unla.UnlaLybrary.service.ICareerService;
import com.unla.UnlaLybrary.service.IUniversityService;

@Controller
@RequestMapping("/career")
public class CareerController {

	@Autowired
	@Qualifier("careerService")
	private ICareerService careerService;
	
	@Autowired
	@Qualifier("universityService")
	private IUniversityService universityService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CAREER_INDEX);
		mAV.addObject("careers", careerService.getAlls());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CAREER_NEW);
		mAV.addObject("career", new CareerModel());
		mAV.addObject("universities",universityService.getAlls());
		return mAV;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("career") CareerModel careerModel) {
		careerService.insert(careerModel);
		return new RedirectView(ViewRouteHelper.CAREER_ROOT);
	}
	
	@GetMapping("/{idCareer}")
	public ModelAndView get(@PathVariable("idCareer") long idCareer) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CAREER_UPDATE); 
		mAV.addObject("career", careerService.findByIdCareer(idCareer));
		//mAV.addObject("universities",universityService.findById(idCareer));
		return mAV;
	}
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("career") CareerModel careerModel) {
		careerService.update(careerModel);
		return new RedirectView(ViewRouteHelper.CAREER_ROOT);
	}
	
	@GetMapping("/university/{university_id}")
	public ModelAndView getByUniversityId(@PathVariable("university_id") long universityId) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.CAREER_INDEX);
		mV.addObject("careers", careerService.findByIdUniversity(universityId));
		return mV;
	}
	
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete/{idCareer}")
	public RedirectView delete(@PathVariable("idCareer") long idCareer) {
		careerService.remove(idCareer);
		return new RedirectView(ViewRouteHelper.CAREER_ROOT);
	}
	
}
