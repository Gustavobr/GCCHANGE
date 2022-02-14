package com.grpbg.Poc.UTIL;

import java.util.Properties;

public class SendMail {
	
	
	private String[] autorizadores = {};
	
	
	
	
	
	
	public static void exec() throws Exception {
		
		final String username = System.getenv("email");
		final String password = System.getenv("password");
		
		
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.port", "587");
		
		
	}

}
