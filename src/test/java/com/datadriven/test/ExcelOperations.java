package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {
	public static void main(String[] args) {
		//get test data from excel file
		Xls_Reader reader = new Xls_Reader("D:\\QAPractices\\com.SDET.DataDriven\\src\\test\\java\\com\\testdata\\ebaytestdata.xlsx");
		
		if(!reader.isSheetExist("home")) {
		   reader.addSheet("home");
		}
		int colCount = reader.getColumnCount("RegistrationData");
		System.out.println("Total column count in Registration Data sheet : " + colCount);
		System.out.println(reader.getCellRowNum("RegistrationData", "firstname", "Steve"));
	}

}
