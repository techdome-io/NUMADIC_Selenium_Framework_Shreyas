package LibaryFiles;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "fieldValidation")
	public String[][] getData1() throws IOException {
		String path = ".\\TestData\\TestDataSheet.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String fieldValidation[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				fieldValidation[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return fieldValidation;

	}


}
