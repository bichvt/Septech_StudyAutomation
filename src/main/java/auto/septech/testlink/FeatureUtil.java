package auto.septech.testlink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.HashMap;

import auto.septech.utilities.TestLogger;

public class FeatureUtil {
	public static String feature="";
	public static String background="";
	public static ArrayList<HashMap<String,String>> caseList=null;
	private static BufferedReader br;
	private static BufferedReader tempbr;
	private BufferedReader br1;

	/**
	 * Get file list in folder
	 * @param folder
	 * @return
	 */
	public static ArrayList<String> listFilesForFolder(String path) {
		String fs = File.separator;
		String tempFile="";
		String temp="";
		File folder = new File(path);
		ArrayList<String> fileName=new ArrayList<String>();
		if(folder.isFile()){
			TestLogger.info("root folder is file");
			fileName.add(path.replace("/", fs).replace("\\", fs));
		}
		else{
			for (File fileEntry : folder.listFiles()) {
				if (fileEntry.isFile()) {
					temp = fileEntry.getName();
					if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("feature")){
						tempFile = folder.getAbsolutePath()+ "/" + fileEntry.getName();
						fileName.add(tempFile.replace("/", fs).replace("\\", fs));
					}
					tempFile="";
				}
				else{
					for (File fileEntry1 : fileEntry.listFiles()) {
						if (fileEntry1.isFile()) {
							temp = fileEntry1.getName();
							if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("feature")){
								tempFile = fileEntry.getAbsolutePath()+ "/" + fileEntry1.getName();
								fileName.add(tempFile.replace("/", fs).replace("\\", fs));
							}
							tempFile="";
						}
					}
				}

			}
		}
		return fileName;
	}
	/**
	 * Get file list in folder
	 * @param folder
	 * @return
	 */
	public static ArrayList<String> listObjectFiles(String path) {
		String fs = File.separator;
		String tempFile="";
		String temp="";
		File folder = new File(path);
		ArrayList<String> fileName=new ArrayList<String>();
		if(folder.isFile()){
			TestLogger.info("root folder is file");
			fileName.add(path.replace("/", fs).replace("\\", fs));
		}
		else{
			for (File fileEntry : folder.listFiles()) {
				if (fileEntry.isFile()) {
					temp = fileEntry.getName();
					if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("properties")){
						tempFile = folder.getAbsolutePath()+ "/" + fileEntry.getName();
						fileName.add(tempFile.replace("/", fs).replace("\\", fs));
					}
					tempFile="";
				}
				else{
					for (File fileEntry1 : fileEntry.listFiles()) {
						if (fileEntry1.isFile()) {
							temp = fileEntry1.getName();
							if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("properties")){
								tempFile = fileEntry.getAbsolutePath()+ "/" + fileEntry1.getName();
								fileName.add(tempFile.replace("/", fs).replace("\\", fs));
							}
							tempFile="";
						}
					}
				}

			}
		}
		return fileName;
	}
	/**
	 * Read file
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readFile(String filename) throws FileNotFoundException, IOException{
		TestLogger.info("read file "+filename);
		String fs = File.separator;
		br = new BufferedReader(new FileReader(filename.replace("/", fs).replace("\\", fs)));
		tempbr = new BufferedReader(new FileReader(filename.replace("/", fs).replace("\\", fs)));
		caseList=new ArrayList<HashMap<String,String>>();
		feature="";
		background="";
		StringBuilder fture = new StringBuilder();
		StringBuilder bground= new StringBuilder();
		StringBuilder tcase = new StringBuilder();
		StringBuilder tcaseSummary = new StringBuilder();
		HashMap<String,String> testcase = new HashMap<String,String>();
		String line = br.readLine();
		String tempLine = tempbr.readLine();
		tempLine = tempbr.readLine();
		while (line!=null) {
			if(line.toLowerCase().contains("feature")){
				//Get feature
				fture.append(line);
				fture.append(System.lineSeparator());
				TestLogger.info(fture.toString().substring(fture.toString().indexOf(":")+1).trim());
			}
			if(line.toLowerCase().contains("background")){
				//Get background
				bground.append(line);
				bground.append(System.lineSeparator());
				while (tempLine!=null) {
					if(tempLine.toLowerCase().contains("scenario")){
						break;
					}
					if(!tempLine.toLowerCase().contains("#case id")&&!tempLine.toLowerCase().contains("#case name")){
						tempLine=tempLine.trim();
						if(tempLine.length()!=0){
							//bground.append("<br>");
							bground.append(tempLine);
							bground.append("\n");
							//bground.append("</br>");
							//bground.append(System.lineSeparator());
						}
					}
					tempLine = tempbr.readLine();
					line = br.readLine();
				}
			}
			if(line.toLowerCase().contains("scenario")){
				//get test case
				tcase.append(line);
				tcase.append(System.lineSeparator());
				while (tempLine!=null) {
					if(tempLine.toLowerCase().contains("scenario")){
						break;
					}
					if(!tempLine.toLowerCase().contains("#case id")&&!tempLine.toLowerCase().contains("#case name")){
						tempLine=tempLine.trim();
						if(tempLine.length()!=0){
							//tcaseSummary.append("<br>");
							tcaseSummary.append(tempLine);
							tcaseSummary.append("\n");
							//tcaseSummary.append("</br>");
							//tcaseSummary.append(System.lineSeparator());
						}
					}
					tempLine = tempbr.readLine();
					line = br.readLine();
				}
				testcase.put("name",tcase.toString().substring(tcase.toString().indexOf(":")+1).trim());
				testcase.put("summary",tcaseSummary.toString());
				caseList.add(testcase);
				tcase = new StringBuilder();
				tcaseSummary = new StringBuilder();
				testcase = new HashMap<String,String>();
			}
			tempLine = tempbr.readLine();
			line = br.readLine();
		}
		background=bground.toString();
		feature=fture.toString().substring(fture.toString().indexOf(":")+1).trim();
		TestLogger.info("finish read file");
	}

	/**
	 * Read object file
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readObjectFile(String filename) throws FileNotFoundException, IOException{
		TestLogger.info("read file "+filename);
		String fs = File.separator;
		br1 = new BufferedReader(new FileReader(filename.replace("/", fs).replace("\\", fs)));
		StringBuilder bground= new StringBuilder();
		String line = br1.readLine();
		while (line!=null) {
			//Get content
			bground.append(line);
			bground.append("\n");
			line=br1.readLine();
		}
		return bground.toString();
	}
}
