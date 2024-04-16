package com.app.nobeds.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility implements PathConstants
{
	static Properties p;
	/**
	 *  used to read data from propertyfile
	 * @param keyname
	 * @return
	 */
	public static String getDataFromPropertyFile(String keyname)
	{
		p=new Properties();
		try {
			p.load(new FileInputStream(propertyfilepath));
		} 
		catch (Exception e) 
		{

		}
		return p.getProperty(keyname);
	}

}
