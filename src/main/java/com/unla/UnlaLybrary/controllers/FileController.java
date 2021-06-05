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
import com.unla.UnlaLybrary.models.FileModel;
import com.unla.UnlaLybrary.service.ISubjectService;
import com.unla.UnlaLybrary.service.IFileService;

@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	@Qualifier("fileService")
	private IFileService fileService;
	
	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.FILE_INDEX);
		mAV.addObject("files", fileService.getAlls());
		return mAV;
	}
	
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.FILE_NEW);
		mAV.addObject("file", new FileModel());
		mAV.addObject("subject",subjectService.getAlls());
		return mAV;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("file") FileModel fileModel) {
		fileService.insert(fileModel);
		return new RedirectView(ViewRouteHelper.FILE_ROOT);
	}
	
	@GetMapping("/{idFile}")
	public ModelAndView get(@PathVariable("idFile") long idFile) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.FILE_UPDATE); 
		mAV.addObject("file", fileService.findByIdFile(idFile));
		return mAV;
	}
	
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("file") FileModel fileModel) {
		fileService.update(fileModel);
		return new RedirectView(ViewRouteHelper.FILE_ROOT);
	}
	
	@GetMapping("/subject/{subject_id}")
	public ModelAndView getBySubjectId(@PathVariable("subject_id") long subjectId) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.FILE_INDEX);
		mV.addObject("files", fileService.findByIdSubject(subjectId));
		return mV;
	}
	
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete/{idFile}")
	public RedirectView delete(@PathVariable("idFile") long idFile) {
		fileService.remove(idFile);
		return new RedirectView(ViewRouteHelper.FILE_ROOT);
	}
	
}