package customreport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import testsuite.testforhtml;


public class VinodCustomReport implements IReporter {
	
	public String path;
	public String filename;
	public String reporttitle;
	public ArrayList<String> environmentheader = new ArrayList<String>();
	public ArrayList<String> environmentheadervalue = new ArrayList<String>();
	public ArrayList<String> suitename = new ArrayList<String>();
	
	
	//TESTNG OVERRIDED METHOD WHERE WE GET RESULT DETAILS FROM TESTNG
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		path = System.getProperty("user.dir");
		filename = "Vinodhtmlfile";
		try {
			for(ISuite tempSuite: suites){
				suitename.add(tempSuite.getName());	
			}
		
			testforhtml generatehtmlcontents = new testforhtml();
			generatehtmlcontents.generateReports(path, filename, suitename);
		

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public boolean setSuiteNames(List<ISuite> suites) {
		
		boolean suitenamedone = false;
		
		for(ISuite tempSuite: suites){
			suitename.add(tempSuite.getName());	
			suitenamedone = true;
		}
		
		return suitenamedone;
	}
	
	public ArrayList<String> getSuiteNames(){
		return suitename;
	}
	
	//SETTING ENVIRONMENT DETAILS AND GETTING THE ENV DETAILS USING GET METHODS
	public void setEnvironmentDetails(String keyvalue,String pairvalue) {
		environmentheader.add(keyvalue);
		environmentheadervalue.add(pairvalue);
	}
	
	public ArrayList<String> getEnvironmentHeader() {
		return this.environmentheader;
	}
	
	public ArrayList<String> getEnvironmentHeadervalue() {
		return this.environmentheadervalue;
	}
	
	
	
	//SETTING REPORT TITLE AND GETTING THE REPORT TITLE USING GET METHODS
	public void setReportTitle(String title) {
		this.reporttitle = title;
	}
	
	public String getReportTitle() {
		return this.reporttitle;
	}

	
	
	public void generatehtml(ArrayList<String> suitename) {
		StringBuilder htmlStringBuilder=new StringBuilder();
		htmlStringBuilder.append("<html><head><title>"+suitename.get(0).toString()+"</title></head>");
		try {
			WriteToFile(htmlStringBuilder.toString(),"testfile.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void WriteToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator+fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator+ "backup_"+fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();
    }
	
}
