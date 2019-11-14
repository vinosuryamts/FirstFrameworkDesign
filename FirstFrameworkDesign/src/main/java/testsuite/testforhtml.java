package testsuite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class testforhtml {
	
	static String SeleniumTest = "Vinod";
	StringBuilder filecontentval;
		
	public void generateReports(String path,String filename,ArrayList<String> suitename) {
		
		filecontentval = new StringBuilder();
		filecontentval = generatefilecontent(path,suitename);
		
		try {
			WriteToFile(path,filecontentval.toString(),filename+".html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public StringBuilder generatefilecontent(String path,ArrayList<String> suitename) {
		
		StringBuilder htmlStringBuilder=new StringBuilder();
		
		htmlStringBuilder.append("<html><head><title>"+suitename.get(0).toString()+"</title></head>");
		
		return htmlStringBuilder;
		
	}
	
	public static void WriteToFile(String path,String fileContent, String fileName) throws IOException {
        String projectPath = path;
        String tempFile = projectPath + File.separator+fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
            	file.delete();
                File newFileName = new File(projectPath + File.separator+ fileName);
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
