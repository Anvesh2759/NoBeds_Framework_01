package com.app.nobeds.testscripts;

import org.testng.annotations.Test;

import com.app.nobeds.genericutility.BaseClass;
import com.app.nobeds.genericutility.HashMaps;
import com.app.nobeds.webpages.LoginPage;

public class TestLogin extends BaseClass
{
	@Test
	public void testlogin()
	{
		LoginPage rv=new LoginPage(driver);
		HashMaps.addDataToHashMap("LoginSheet");
		String user = HashMaps.getDataFromHashMap("Username");
		String pwd = HashMaps.getDataFromHashMap("Password");
		rv.setLoginCredentials(user, pwd);
		rv.clickOnLoginButton();
	}

}
