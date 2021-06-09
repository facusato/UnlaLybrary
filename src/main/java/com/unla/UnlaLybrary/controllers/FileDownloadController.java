package com.unla.UnlaLybrary.controllers;


import java.io.File;
import java.io.FileInputStream;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FileDownloadController {
	String folderPath="C:\\uploads";
	
	@RequestMapping("/f")
	public String showFiles(Model model) {
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
		model.addAttribute("files", listOfFiles);
		return "showFiles";
	}
	
	
	@RequestMapping("/download/{fileName}")
	public void download(@PathVariable("fileName") String fileName,HttpServletResponse response) throws Exception {
		// Dirección del archivo, el entorno real se almacena en la base de datos
		File file = new File("C:\\uploads\\"+fileName);
		 // Llevando objeto de entrada
		FileInputStream fis = new FileInputStream(file);
		 // Establecer el formato relevante
		response.setContentType("application/force-download");
		 // Establecer el nombre y el encabezado del archivo descargado
		response.addHeader("Content-disposition", "attachment;fileName=" + fileName);
		 // Crear objeto de salida
		OutputStream os = response.getOutputStream();
		 // operación normal
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = fis.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		fis.close();
	}
	
}