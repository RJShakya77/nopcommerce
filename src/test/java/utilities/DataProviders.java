package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvide =1 
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path ="C:\\MyWorkSpace\\nopcommerce\\testData\\nopCommerce_LoginData.xlsx"; // taking xlsx file from testdata
		
		ExcelUtility eu = new ExcelUtility(path); // creating an object of ExcelUtility class
	 
		int totalrows =eu.getRowCount("Sheet1");
		int totalcols = eu.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcols]; // created two dimension array which can 
		
		for(int i=1; i<totalrows;i++) 
		{
			for(int j=0;j<totalcols;j++) 
			{
				logindata[i-1][j]= eu.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata; // returning two dimension array
		}
	
}
