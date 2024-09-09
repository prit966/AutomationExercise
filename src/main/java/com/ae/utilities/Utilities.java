package com.ae.utilities;

import java.util.Date;

public class Utilities {

	public static final int implicit_wait_time=20;
	public static final int page_load_time=10;
		
		
		public static String generateEmailWithTimeStamp() {
			
			Date date=new Date();
			String timestamp = date.toString().replace(" ", "_").replace(":", "_");
			return "ppawar" + timestamp + "@gmail.com";
		}
	}


