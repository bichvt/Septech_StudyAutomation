package auto.septech.steps;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.apache.commons.io.FileUtils;
import auto.septech.coreactions.DialogAndAlert;
import auto.septech.coreactions.CoreActionForm;
import auto.septech.coreactions.DateTime;
import auto.septech.coreactions.ManageFileAction;
import auto.septech.coreactions.PageCore;
import auto.septech.coreactions.WindowsAndFrames;
import auto.septech.databases.ConnectDatabase;
import auto.septech.utilities.RandomData;
import auto.septech.utilities.TestLogger;

public class EndUserBaseSteps extends ScenarioSteps {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PageCore pageCore;
	DialogAndAlert dialogsAndAlert;
	CoreActionForm mainActionForm;
	ManageFileAction manageFileAction;
	WindowsAndFrames windowsAndFrames;
	RandomData randomData;
	DateTime dateTime = new DateTime();
	ConnectDatabase connectDatabase = new ConnectDatabase();
    public static HashMap<String, String> listVar = new HashMap<String, String>();
    @Step
    public void open_the_home_page(){
    	pageCore.openThePage();
    } 
    
    @Step
 	public void capture_and_save_it(String element, String pathStorge) {
     	try {
     			FileUtils.copyFile(pageCore.captureElementBitmap(element), new File(pathStorge));
 	    	} catch (IOException e) {e.printStackTrace();
 			} catch (Exception e) {	e.printStackTrace();}
     	}

     @Step
 	public void change_attribute_of_element(String attr, String element, String attrValue) {
     	pageCore.setAttribute(attr,element,attrValue);
 	}

     @Step
 	public void highlight_element(String element) {
     	pageCore.highlightElement(element);
 	}

     @Step
 	public void set_bound_for_element(String element) {
     	pageCore.setBounds(element);
 	}
    
    @Step
	public void store_the_text_of_element_in_variable(String element, String var) {
    	String value = pageCore.getWebElement(element).getText();
    	listVar.put(var, value);
	}

    @Step
	public void wait_for_the_element_to_be_clickable(String element) {
    	pageCore.waitUntilElementTobeClickable(element);
	}

    @Step
	public void wait_for_any_text_to_be_present(String textValue) {
    	pageCore.waitForAnyTextToAppear(textValue);
	}
    
    @Step
	public void wait_for_the_element_to_be_visibile(String element) {
    	pageCore.waitUntilElementVisibility(element);
	}

    @Step
	public void wait_for_any_text_to_be_disappread(String textValue) {
    	pageCore.waitForTextToDisappear(textValue);
	}
    
    @Step
  	public void wait_for_any_text_to_be_appread(String textValue) {
      	pageCore.waitForTextToAppear(textValue);
    }
    
    @Step
	public String get_substring_in_string_by_index(String value, Integer begin, Integer end){
		String subString = value.substring(begin, end).trim();
		return subString;
	}
    
	@Step
	public String get_substring_in_string(String value, String beginStr, String endStr){
		String subString = value.substring(value.indexOf(beginStr), value.indexOf(endStr)-1).trim();
		return subString;
	}
	
	@Step
	public void store_date_in_variable(String format,String local, String var){
		if(local==null || local.isEmpty()){
			local="Japan";
		}
		listVar.put(var, dateTime.getCurrentDate(format,local));
		TestLogger.info(listVar.get(var));
	}
	
	@Step
	public void store_the_sub_text_of_variable_by_index_in_variable(String srcvar, Integer beginStr, Integer endStr, String desvar) {
		String text=listVar.get(srcvar);
		String subString = get_substring_in_string_by_index(text,beginStr, endStr);
		listVar.put(desvar, subString);
		TestLogger.info(listVar.get(desvar));
	}

	@Step
	public void store_the_sub_text_of_element_in_variable(String element, String beginStr, String endStr, String var) {
		String value = pageCore.getWebElement(element).getText();
		String subString = value.substring(value.indexOf(beginStr)+1, value.indexOf(endStr)).trim();
		listVar.put(var, subString);
		TestLogger.info(listVar.get(var));
	}

	@Step
	public void store_number_of_element_in_variable(String element, String var){
		Integer number = pageCore.getWebElements(element).size();
		listVar.put(var, String.valueOf(number));
		TestLogger.info(listVar.get(var));
	}

	@Step
	public void store_the_value_of_attribute_in_variable(String attr, String element, String var){
		String value = pageCore.getAttribute(attr,element);
    	listVar.put(var, value);
	}
	
	@Step
	public void store_text_value_in_variable(String text, String var){
		randomData = new RandomData();
		text=randomData.processRandomCucumber(text);
		listVar.put(var, text);
		TestLogger.info(listVar.get(var));
	}
	
	@Step
	public Integer get_number_of_element(String element){
		return pageCore.getWebElements(element).size();
	}
	
	@Step
	public void store_number_in_text_of_element_in_variable(String element, String var){
		String value = pageCore.getWebElement(element).getText();
		String number = pageCore.getNumberInString(value);
		listVar.put(var, String.valueOf(number));
		TestLogger.info(listVar.get(var));
	}
	
	@Step
	public void store_the_result_of_minus_between_variable(String var1, String var2, String var3){
		TestLogger.info(listVar.get(var1));
		TestLogger.info(listVar.get(var2));
		Integer number1 = Integer.valueOf(listVar.get(var1));
		Integer number2 = Integer.valueOf(listVar.get(var2));
		listVar.put(var3, String.valueOf(number1-number2));
		TestLogger.info(listVar.get(var3));
	}
	
	@Step
	public void store_number_in_value_of_variable_in_variable(String srcvar,String desvar){
		String temp=pageCore.getNumberInString(listVar.get(srcvar));
		store_text_value_in_variable(temp,desvar);
	}
	
	@Step
	public void store_number_in_value_of_element_in_variable(String element, String var){
		String value = pageCore.getWebElement(element).getAttribute("value");
		String number = pageCore.getNumberInString(value);
		listVar.put(var, String.valueOf(number));
		TestLogger.info(listVar.get(var));
	}
	
	@Step
	public void store_number_in_string_in_variable(String value, String var){
		randomData = new RandomData();
		value=randomData.processRandomCucumber(value);
		String number = pageCore.getNumberInString(value);
		listVar.put(var, String.valueOf(number));
		TestLogger.info(listVar.get(var));
	}

	
	@Step
	public String get_number_in_string(String value){
		return pageCore.getNumberInString(value);
	}
	
	@Step
	public void store_result_of_jquery(String jquery, String var){
		TestLogger.info(jquery);
		listVar.put(var, pageCore.runJquery(jquery));
		TestLogger.info(listVar.get(var));
	}
	
	@Step
	public void store_number_of_result_of_query(String myQueries, String var) {
		try {
			ResultSet rs = connectDatabase.executeQuery(myQueries);
			rs.last();
			Integer size = rs.getRow();
			rs.beforeFirst();
			listVar.put(var, String.valueOf(size));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestLogger.info(listVar.get(var));
	}
}