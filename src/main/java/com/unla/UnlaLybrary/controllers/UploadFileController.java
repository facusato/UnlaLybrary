package com.unla.UnlaLybrary.controllers;

import com.unla.UnlaLybrary.helpers.ViewRouteHelper;
import com.unla.UnlaLybrary.services.implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/uploadfile")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    @GetMapping("")
    public ModelAndView index(){
    	ModelAndView mAV = new ModelAndView(ViewRouteHelper.FILE_UPLOADD);
    	return mAV;
	
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
        }

        try {
            uploadFileService.saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);
    }
    
    @PostMapping("/uploadMultiple")
    public ResponseEntity uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files){
        if(files.size() == 0){
            return new ResponseEntity("Seleccionar algun archivo",HttpStatus.OK);
        }
        try {
            uploadFileService.saveMultipleFiles(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity("Archivos subidos correctamente",HttpStatus.OK);
    }
    
    
    
}
