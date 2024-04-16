
package com.app.nobeds.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int count=0;
	int maxtry=3;
	public boolean retry(ITestResult result)
	{
		if(!result.isSuccess())
		{
			if(count<maxtry)
			{
				count++;
				return true;
			}
		}
		return false;
	}
	
}

