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
import com.unla.UnlaLybrary.models.SubjectModel;
import com.unla.UnlaLybrary.service.ISubjectService;
import com.unla.UnlaLybrary.service.ICareerService;
import com.unla.UnlaLybrary.service.IFileService;

@Controller
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;
	
	@Autowired
	@Qualifier("careerService")
	private ICareerService careerService;
	
	@Autowired
	@Qualifier("fileService")
	private IFileService fileService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUBJECT_INDEX);
		mAV.addObject("subjects", subjectService.getAlls());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUBJECT_NEW);
		mAV.addObject("subject", new SubjectModel());
		mAV.addObject("careers",careerService.getAlls());
		mAV.addObject("files",fileService.getAlls());
		return mAV;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("subject") SubjectModel subjectModel) {
		subjectService.insert(subjectModel);
		return new RedirectView(ViewRouteHelper.SUBJECT_ROOT);
	}
	
	@GetMapping("/{idSubject}")
	public ModelAndView get(@PathVariable("idSubject") long idSubject) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUBJECT_UPDATE); 
		mAV.addObject("subject", subjectService.findByIdSubject(idSubject));
		mAV.addObject("files",fileService.findByIdSubject(idSubject));
		return mAV;
	}
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("subject") SubjectModel subjectModel) {
		subjectService.update(subjectModel);
		return new RedirectView(ViewRouteHelper.SUBJECT_ROOT);
	}
	
	@GetMapping("/career/{career_id}")
	public ModelAndView getByCareerId(@PathVariable("career_id") long careerId) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.SUBJECT_INDEX);
		mV.addObject("subjects", subjectService.findByIdCareer(careerId));
		return mV;
	}
	
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete/{idSubject}")
	public RedirectView delete(@PathVariable("idSubject") long idSubject) {
		subjectService.remove(idSubject);
		return new RedirectView(ViewRouteHelper.SUBJECT_ROOT);
	}
	
}

