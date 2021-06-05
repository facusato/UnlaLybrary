package com.unla.UnlaLybrary.helpers;

import org.springframework.stereotype.Service;

public class ViewRouteHelper {

/**** Views ****/
	
	//   HOME
	public final static String HOME_INDEX = "home/index";
	
//  CONTACTO
	public final static String CONTACT_INDEX = "contact/index";
	
	public final static String FORM_INDEX = "form/index";
	

	//public final static String FILE_UPLOADD = "file/view";
	public final static String FILE_UPLOADD = "file/uploadFileView";
	public final static String FILE_DOWNLOAD = "file/showFile";
	
	
	
// UNIVERSIDAD
	
    public final static String UNIVERSITY_INDEX = "university/index";
	public final static String UNIVERSITY_NEW = "university/new";
	public final static String UNIVERSITY_UPDATE = "university/update";
	
// CARRERA
	
    public final static String CAREER_INDEX = "career/index";
	public final static String CAREER_NEW = "career/new";
	public final static String CAREER_UPDATE = "career/update";
	
// Materia
	
    public final static String SUBJECT_INDEX = "subject/index";
	public final static String SUBJECT_NEW = "subject/new";
	public final static String SUBJECT_UPDATE = "subject/update";
	
// Materia
	
    public final static String FILE_INDEX = "file/index";
	public final static String FILE_NEW = "file/new";
	public final static String FILE_UPDATE = "file/update";
	
	
	//
	public final static String USER_LOGIN="user/login";
	public final static String USER_LOGOUT="user/logout";
	
	/**** Redirects ****/
	public final static String UNIVERSITY_ROOT = "/university";
	public final static String CAREER_ROOT = "/career";
	public final static String SUBJECT_ROOT = "/subject";
	public final static String FILE_ROOT = "/file";
}
