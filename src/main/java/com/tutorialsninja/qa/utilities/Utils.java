package com.tutorialsninja.qa.utilities;

import java.util.Date;

public class Utils {

	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String emailDateTimeStamp = date.toString().replace(" ","_").replace(":", "_");
		return "choheepa" + emailDateTimeStamp + "@gmail.com";
	}
	public final static int IMPLICIT_WAIT = 100;
	public final static int PAGELOAD_TIME = 100;
	public final static int SCRIPT_TIME = 1000;
}
