package com.datadriven.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebTableHandle {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\blver\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver(); //launch chrome
		
		Driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeXpath_Company = "//*[@id='customers']/tbody/tr[";
		String afterXpath_Company = "]/td[1]";
		
		String beforeXpath_Contact = "//*[@id='customers']/tbody/tr[";
		String afterXpath_Contact = "]/td[2]";
		
		String beforeXpath_Country = "//*[@id='customers']/tbody/tr[";
		String afterXpath_Country = "]/td[3]";
		
		List <WebElement> Rows = Driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int RowCount = Rows.size();
		System.out.println("Total Rows : " + RowCount);
		
		System.out.println("------------------------------------------");
		
		Xls_Reader reader = new Xls_Reader("D:\\QAPractices\\com.SDET.DataDriven\\src\\test\\java\\com\\testdata\\htmltable.xlsx");
		
		if(!reader.isSheetExist("TableData")) {
		reader.addSheet("TableData");
		}
		
		reader.addColumn("TableData", "CompanyName");
		reader.addColumn("TableData", "ContactName");
		reader.addColumn("TableData", "CountryName");


		for(int rowNo=2; rowNo<=RowCount; rowNo++) {
			String actualXpath_Company = beforeXpath_Company + rowNo + afterXpath_Company;
			String CompanyName = Driver.findElement(By.xpath(actualXpath_Company)).getText();
			System.out.println(CompanyName); 
			reader.setCellData("TableData", "CompanyName", rowNo, CompanyName);
			
			String actualXpath_Contact = beforeXpath_Contact + rowNo + afterXpath_Contact;
			String ContactName = Driver.findElement(By.xpath(actualXpath_Contact)).getText();
			System.out.println(ContactName);
			reader.setCellData("TableData", "ContactName", rowNo, ContactName);

			String actualXpath_Country = beforeXpath_Country + rowNo + afterXpath_Country;
			String CountryName = Driver.findElement(By.xpath(actualXpath_Country)).getText();
			System.out.println(CountryName);
			reader.setCellData("TableData", "CountryName", rowNo, CountryName);
			
			System.out.println("=============================");
		}
		
		Driver.close();
	}
}
