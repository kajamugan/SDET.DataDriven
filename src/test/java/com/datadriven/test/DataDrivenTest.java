package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {
public static void main(String[] args) {

			//get test data from excel file
			Xls_Reader reader = new Xls_Reader("D:\\QAPractices\\com.SDET.DataDriven\\src\\test\\java\\com\\testdata\\ebaytestdata.xlsx");
			
			String FirstName = reader.getCellData("RegistrationData", "firstname", 2);
			System.out.println(FirstName);
			
			String LastName = reader.getCellData("RegistrationData", "lastname", 2);
			System.out.println(LastName);
			
			String Email = reader.getCellData("RegistrationData", "email", 2);
			System.out.println(Email);
			
			String Password = reader.getCellData("RegistrationData", "password", 2);
			System.out.println(Password);
			
			
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\blver\\Desktop\\chromedriver_win32\\chromedriver.exe");
			WebDriver Driver = new ChromeDriver(); //launch chrome
					
			Driver.get("https://signup.ebay.com/pa/crte?siteid=0&co_partnerId=0&UsingSSL=1&rv4=1&ru=https%3A%2F%2Fwww.ebay.com%2F&signInUrl=https%3A%2F%2Fwww.ebay.com%2Fsignin%3Fsgn%3Dreg%26siteid%3D0%26co_partnerId%3D0%26UsingSSL%3D1%26rv4%3D1%26ru%3Dhttps%253A%252F%252Fwww.ebay.com%252F	"); //enter the URL
					
			Driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(FirstName);
		    Driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(LastName);
		    Driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Email);
		    Driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		    
		    

}
}
