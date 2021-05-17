package com.unla.UnlaLybrary;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCryptPasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder(4); 
		System.out.println(pe.encode("administrador"));
		System.out.println(pe.encode("alumno"));
		System.out.println(pe.encode("docente"));

	}
}