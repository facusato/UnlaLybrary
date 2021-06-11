package com.unla.UnlaLybrary.controllers;

import com.unla.UnlaLybrary.helpers.ViewRouteHelper;
import com.unla.UnlaLybrary.service.ICareerService;
import com.unla.UnlaLybrary.service.IFileService;
import com.unla.UnlaLybrary.services.implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/uploadfile")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;
    
    
    @Autowired
	@Qualifier("fileService")
	private IFileService fileService;

    @GetMapping("")
    public ModelAndView index(){
    	ModelAndView mAV = new ModelAndView(ViewRouteHelper.FILE_UPLOADD);
    	return mAV;
	
    }

    @PostMapping("/upload")
    public ModelAndView uploadFile(@RequestParam("pdffFile") MultipartFile pdffFile,RedirectAttributes redirectAttrs) {
        if (pdffFile.isEmpty()) {
        	redirectAttrs.addFlashAttribute("mensaje","El apunte esta Vacio");
			redirectAttrs.addFlashAttribute("clase", "danger");
            
        }

        try {
            uploadFileService.saveFile(pdffFile);
         
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        redirectAttrs.addFlashAttribute("mensaje","El apunte se cargo correctamente");
		redirectAttrs.addFlashAttribute("clase", "danger");
		ModelAndView mV = new ModelAndView(new RedirectView("/"));
        return mV;
    }
    
    @PostMapping("/uploadMultiple")
    public ModelAndView uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files,RedirectAttributes redirectAttrs){
        if(files.size() == 0){
            
        }
        try {
            uploadFileService.saveMultipleFiles(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttrs.addFlashAttribute("mensaje","Los apuntes se cargaron correctamente");
		redirectAttrs.addFlashAttribute("clase", "danger");
        ModelAndView mV = new ModelAndView(new RedirectView("/"));
        return mV;
    }
    
    
    
}
