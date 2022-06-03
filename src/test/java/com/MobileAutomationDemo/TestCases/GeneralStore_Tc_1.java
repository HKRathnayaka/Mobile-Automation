package com.MobileAutomationDemo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MobileAutomationDemo.PageObjects.GeneralStorePage;
import com.MobileAutomationDemo.PageObjects.ProductsPage;
import com.MobileAutomationDemo.Utilities.Utilities;

public class GeneralStore_Tc_1 extends BaseClass{
	
	public static String expectedMessage = "Please enter your name";
	public static String country = "Australia";
	public static String name = "John Doe";
	public static String invalidName = "Doe";
	
	@Test(priority = 1)
	public void validateToastMessage(){
		
		GeneralStorePage gsp = new GeneralStorePage(driver);
		
		gsp.btnLetsShop.click();
		
		String toastMessage = gsp.lblToastMsg.getAttribute("name");
		Assert.assertEquals(expectedMessage, toastMessage);
		System.out.println("Validation success. Expected toast message displayed");
		
	}
	
	@Test(priority = 2)
	public void productsPageNavigation() throws InterruptedException{
		
		GeneralStorePage gsp = new GeneralStorePage(driver);
		
//		gsp.txtName.sendKeys(invalidName);
//		driver.hideKeyboard();
//		
//		gsp.txtName.getText();
//		if(gsp.txtName.getText().length() <= 3){
//			System.out.println("Validation Failed. Name must include atleast 4 characters");
//			Assert.assertTrue(false);
//		}
		
		gsp.ddCountry.click();
		
		Utilities u=new Utilities(driver);
	    u.scrollToCountry(country);
	
		gsp.lblCountry.click();
		
		gsp.txtName.sendKeys(name);
		driver.hideKeyboard();
		
		gsp.radioGender.click();
		gsp.btnLetsShop.click();
		
		ProductsPage pp = new ProductsPage(driver);
		Thread.sleep(1000);
		
		Assert.assertTrue(pp.lblProducts.isDisplayed());
		System.out.println("Successfully navigated to products page");
		
	}

}
