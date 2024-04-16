
package com.app.nobeds.genericutility;

import java.util.HashMap;



public class HashMaps 
{
	/**
	 * used to add data from Excel to hashmap
	 */
	static HashMap<String, String> m;
	public static void addDataToHashMap(String sheetname)
	{
		m=new HashMap<String, String>();
		Excel.openExcel();
		Excel.identifySheet(sheetname);
		int rowcount = Excel.totalRowCount();
		for(int rownum=0;rownum<=rowcount;rownum++)
		{
			Excel.identifyRow(rownum);
			String key = Excel.identifyCellData(0);
			String value = Excel.identifyCellData(1);
			m.put(key, value);
		}
		
	}
	/**
	 * used to read data from hashmap
	 * @param keyname
	 * @return
	 */
	public static String getDataFromHashMap(String keyname)
	{
		return m.get(keyname);
	}
}
