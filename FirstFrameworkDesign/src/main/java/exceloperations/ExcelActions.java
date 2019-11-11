package exceloperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelActions {

	Workbook book;
	Sheet getsheetdetails;
	
	public Sheet getexcelworkbook(String path,String sheetname) {
		
		File excelfile = new File(path);
		
		try {
			
			FileInputStream inputstream = new FileInputStream(excelfile);
			
			String fileextenstion = FilenameUtils.getExtension(path);
			
			if(fileextenstion.equals("xls")) {
				try {
					book = new HSSFWorkbook(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Unable to open HSSFWorkbook");
				}
			}else if (fileextenstion.equals("xlsx")){
				try {
					book = new XSSFWorkbook(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Unable to open XSSFWorkbook");
				}
			}else {
				System.out.println("Invalid excel input format");
			}
			
			getsheetdetails = book.getSheet(sheetname);

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable read file from InputStream");
		}
		
				
		return getsheetdetails;
	}
	
}
