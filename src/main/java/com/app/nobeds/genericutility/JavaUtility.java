package com.app.nobeds.genericutility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility implements PathConstants
{
	Date date;
	static String dateformate;
	File f;
	/**
	 * used to identify current date
	 * @return
	 */
	public String generateDate()
	{
		date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd_MM_yyyy");
		return dateformate=sf.format(date);
		
	}
	/**
	 * used to create new folder
	 */
	public String createFolder()
	{
		f=new File(folderpath+"screenshots@"+dateformate);
		f.mkdir();
		 return f.getAbsolutePath();
	}
	/**
	 * used to identify images folder location
	 * @return
	 */
	public String  getScreenshotFolderLocation()
	{
		return f.getAbsolutePath();
	}
	

}
