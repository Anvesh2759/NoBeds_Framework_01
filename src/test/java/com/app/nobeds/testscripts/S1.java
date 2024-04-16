package com.app.nobeds.testscripts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class S1 {

	public static void main(String[] args)
	{
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd_MM_yyyy");
		System.out.println(sf.format(date));

	}

}
