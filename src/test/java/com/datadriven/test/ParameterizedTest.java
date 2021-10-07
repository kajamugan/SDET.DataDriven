package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizedTest {
		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\blver\\Desktop\\chromedriver_win32\\chromedriver.exe");
			WebDriver Driver = new ChromeDriver(); //launch chrome
					
			Driver.get("https://signup.ebay.com/pa/crte?siteid=0&co_partnerId=0&UsingSSL=1&rv4=1&ru=https%3A%2F%2Fwww.ebay.com%2F&signInUrl=https%3A%2F%2Fwww.ebay.com%2Fsignin%3Fsgn%3Dreg%26siteid%3D0%26co_partnerId%3D0%26UsingSSL%3D1%26rv4%3D1%26ru%3Dhttps%253A%252F%252Fwww.ebay.com%252F	"); //enter the URL
			
			
			//get test data from excel file
			Xls_Reader reader = new Xls_Reader("D:\\QAPractices\\com.SDET.DataDriven\\src\\test\\java\\com\\testdata\\ebaytestdata.xlsx");
			
			//initialization for row count
			int RowCount = reader.getRowCount("RegistrationData");
			
			//add column in excel sheet
			reader.addColumn("RegistrationData", "status");
			
			//Parameterization with for loop
			for(int RowNum=2; RowNum<=RowCount; RowNum++) {
				String FirstName = reader.getCellData("RegistrationData", "firstname", RowNum);
				System.out.println(FirstName);
				
				String LastName = reader.getCellData("RegistrationData", "lastname", RowNum);
				System.out.println(LastName);
				
				String Email = reader.getCellData("RegistrationData", "email", RowNum);
				System.out.println(Email);
				
				String Password = reader.getCellData("RegistrationData", "password", RowNum);
				System.out.println(Password);
				
			
				//web elements identify by using Xpath
				Driver.findElement(By.xpath("//input[@id='firstname']")).clear();
				Driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(FirstName);
				
				Driver.findElement(By.xpath("//input[@id='lastname']")).clear();
			    Driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(LastName);
			    
			    Driver.findElement(By.xpath("//input[@id='Email']")).clear();
			    Driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Email);
			    
			    Driver.findElement(By.xpath("//input[@id='password']")).clear();
			    Driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
			    
			    //write the data into the particular cell
			    reader.setCellData("RegistrationData", "status", RowNum, "Pass");
			    
			}
			
		}
}
