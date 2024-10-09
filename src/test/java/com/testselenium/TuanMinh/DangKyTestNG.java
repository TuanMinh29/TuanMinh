package com.testselenium.TuanMinh;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DangKyTestNG {
	
	@DataProvider(name = "registrationData")
	public Object[][] registrationData() {
		return new Object[][] {
			{ "existingUser", "WeakPass1", false },    
			{ "newUser", "weak", false },              
			{ "newUser", "StrongPass1", true },                      
			{ "newUser", "", false },                  
			{ "newUser", "short", false },           
			{ "newUser", "strongpass", false },        
			{ "newUser", "Short1", false },            
			{ "validUser", "ValidPass1", true } 
		};
	}
	
  @Test(dataProvider = "registrationData")
  public void testUserRegistration(String username, String password, boolean expectedOutcome) {
	  boolean actualOutcome = registerUser(username, password);
	  Assert.assertEquals(actualOutcome, expectedOutcome, "Dang ky thanh cong");
  }
  private boolean registerUser(String username, String password) {
	  if (username.equals("existingUser")) return false;
	  if (password.length() < 8 || !password.matches(".*[A-Z].*")) return false;
	  return true;
  }
}
