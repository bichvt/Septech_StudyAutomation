package auto.septech.testlink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import auto.septech.utilities.PropertiesUtil;
import auto.septech.utilities.TestLogger;
import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ActionOnDuplicate;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.constants.TestCaseDetails;
import br.eti.kinoshita.testlinkjavaapi.constants.TestImportance;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.Platform;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.model.TestSuite;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class TestLinkBase {
	public static String pathFeature="";
	public static String pathFileToWriteTestLink="";
	public static String devKey="";
	public static String url="";
	public static String project="";
	public static String testProjectPrefix="";
	public static String platformName="";
	public static String reportPath="";
	public static String tagName="";
	public static String planName="";
	public static String buildName="";

	/**
	 * getSystemProperty
	 * @author phuong_dt
	 * @throws IOException 
	 */
	public void getSystemProperty() throws IOException{
		pathFeature = System.getProperty("pathFeature");
		pathFileToWriteTestLink = System.getProperty("pathFileToWriteTestLink");
		devKey = System.getProperty("devKey");
		url = System.getProperty("url");
		project = System.getProperty("project");
		platformName = System.getProperty("platformName");
		reportPath = System.getProperty("reportPath");
		tagName = System.getProperty("tagName");
		planName = System.getProperty("planName");
		buildName = System.getProperty("buildName");

		if (pathFeature==null || pathFeature=="") 
			pathFeature = PropertiesUtil.load_config_sys().getProperty("testlink.pathFeature");
		if (pathFileToWriteTestLink==null || pathFileToWriteTestLink=="") 
			pathFileToWriteTestLink = PropertiesUtil.load_config_sys().getProperty("testlink.pathFileToWriteTestLink");
		if (devKey==null || devKey=="") 
			devKey = PropertiesUtil.load_config_sys().getProperty("testlink.devKey");
		if (url==null || url=="") 
			url = PropertiesUtil.load_config_sys().getProperty("testlink.url");
		if (project==null || project=="") 
			project = PropertiesUtil.load_config_sys().getProperty("testlink.project");
		if (testProjectPrefix==null || testProjectPrefix=="") 
			testProjectPrefix = PropertiesUtil.load_config_sys().getProperty("testlink.testProjectPrefix");
		if (platformName==null || platformName=="") 
			platformName = PropertiesUtil.load_config_sys().getProperty("testlink.platformName");
		if (reportPath==null || reportPath=="") 
			reportPath = PropertiesUtil.load_config_sys().getProperty("testlink.reportPath");
		if (planName==null || planName=="") 
			planName = PropertiesUtil.load_config_sys().getProperty("testlink.planName");
		if (buildName==null || buildName=="") 
			buildName = PropertiesUtil.load_config_sys().getProperty("testlink.buildName");

		String fs = File.separator;
		pathFeature=System.getProperty("user.dir")+"/"+pathFeature.replace("/", fs).replace("\\", fs);
		//pathFileToWriteTestLink=System.getProperty("user.dir")+"/"+pathFileToWriteTestLink.replace("/", fs).replace("\\", fs);
		reportPath=System.getProperty("user.dir")+"/"+reportPath.replace("/", fs).replace("\\", fs);
	}

	/**
	 * Gconnect test link
	 * @author phuong_dt
	 * @param url
	 * @param devkey
	 */
	public TestLinkAPI connectTestLink(String url, String devkey){
		TestLogger.info("open testlink");
		URL testlinkURL = null;
		TestLinkAPI testLinkApi = null;
		try {
			testlinkURL = new URL(url);
		} catch ( MalformedURLException mue ) {
			mue.printStackTrace( System.err );
		}

		try {
			testLinkApi=new TestLinkAPI(testlinkURL,devkey);
			TestLogger.info("connected");
		} catch( TestLinkAPIException te) {
			te.printStackTrace( System.err );
		}
		return testLinkApi;
	}

	/**
	 * Get test projects from test link
	 * @author phuong_dt
	 * @param api
	 * @return
	 */
	ArrayList<TestProject> getTestProjects(TestLinkAPI api){
		ArrayList<TestProject> list = new ArrayList<TestProject>();
		TestProject[]arrTestProjects = api.getProjects();
		for(int i = 0; i<arrTestProjects.length; i++){
			list.add(i,arrTestProjects[i]);
		}
		return list;
	}

	/**
	 * verify project is exist or not
	 * @param api
	 * @param projectName
	 * @return
	 */
	Boolean isProjectPresent(TestLinkAPI api, String projectName){
		Boolean isPresent = false;
		ArrayList<TestProject> projectList = getTestProjects(api);
		for(int i=0; i<projectList.size(); i++){
			if(projectList.get(i).getName().toLowerCase().equals(projectName.toLowerCase())){
				isPresent=true;
				break;
			}
		}
		return isPresent;
	}

	/**
	 * get projectId
	 * @param api
	 * @param projectName
	 * @return
	 */
	Integer getProjectIdByName(TestLinkAPI api, String projectName){
		Integer projectId = null;
		ArrayList<TestProject> projectList = getTestProjects(api);
		for(int i=0; i<projectList.size(); i++){
			if(projectList.get(i).getName().toLowerCase().equals(projectName.toLowerCase())){
				projectId=projectList.get(i).getId();
				break;
			}
		}
		return projectId;
	}

	/**
	 * Get test plan
	 * @author phuong_dt
	 * @param api
	 * @param projectId
	 */
	ArrayList<TestPlan> getTestPlan(TestLinkAPI api, Integer projectId){
		ArrayList<TestPlan> list = new ArrayList<TestPlan>();
		TestPlan[]arrTestPlans = api.getProjectTestPlans(projectId);
		for(int i = 0; i<arrTestPlans.length; i++){
			list.add(i,arrTestPlans[i]);
		}
		return list;
	}

	/**
	 * verify test plan exist or not
	 * @param api
	 * @param projectName
	 * @param planName
	 * @return
	 */
	Boolean isTestPlanPresent(TestLinkAPI api, String projectName, String planName){
		Boolean isPresent=false;
		Integer projectId = getProjectIdByName(api,projectName);
		ArrayList<TestPlan> list = getTestPlan(api,projectId);
		for(int i = 0; i<list.size(); i++){
			if(list.get(i).getName().toLowerCase().equals(planName.toLowerCase())){
				isPresent=true;
				break;
			}
		}
		return isPresent;
	}

	/**
	 * Get test suite
	 * @author phuong_dt
	 * @param projectName
	 * @param api
	 */
	ArrayList<TestSuite> getFirstLevelTestSuite(TestLinkAPI api, String projectName){
		ArrayList<TestSuite> list = new ArrayList<TestSuite>();
		TestSuite[]arrTestSuites;
		try {
			Integer projectId = api.getTestProjectByName(projectName).getId();
			arrTestSuites = api.getFirstLevelTestSuitesForTestProject(projectId);
			for(int i = 0; i<arrTestSuites.length; i++){
				list.add(i,arrTestSuites[i]);
			}
		} catch(TestLinkAPIException te) {
		}
		return list;
	}

	/**
	 * Get test suite for one test plan
	 * @author phuong_dt
	 * @param api
	 * @param planName
	 * @param projectName
	 * @return
	 */
	ArrayList<TestSuite> getTestSuiteForTestPlan(TestLinkAPI api,  String planName, String projectName){
		ArrayList<TestSuite> list = new ArrayList<TestSuite>();
		TestSuite[]arrTestSuites;
		try {
			Integer testPlanId = getTestPlanId(api, planName, projectName);
			arrTestSuites = api.getTestSuitesForTestPlan(testPlanId);
			for(int i = 0; i<arrTestSuites.length; i++){
				list.add(i,arrTestSuites[i]);
			}
		} catch(TestLinkAPIException te) {
		}
		return list;
	}

	/**
	 * get test suite by name
	 * @param api
	 * @param suiteName
	 * @param planName
	 * @param projectName
	 * @return
	 */
	Integer getTestSuiteByname(TestLinkAPI api, String suiteName, String planName, String projectName){
		Integer suiteId=null;
		ArrayList<TestSuite> testSuite;
		try {
			testSuite = getTestSuiteForTestPlan(api, planName, projectName);
			TestLogger.info(testSuite.size());
			for(int i = 0; i<testSuite.size(); i++){
				TestLogger.info(testSuite.get(i).getName());
				if(testSuite.get(i).getName().trim()==suiteName){
					suiteId=testSuite.get(i).getId();
					break;
				}
			}
		} catch(TestLinkAPIException te) {
		}
		return suiteId;
	}

	/**
	 * Get Testsuite by id
	 * @author phuong_dt
	 * @param api
	 * @param suiteId
	 */
	TestSuite getTestSuiteById(TestLinkAPI api, Integer suiteId){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(suiteId);
		TestSuite[] suiteName = api.getTestSuiteByID(ids);
		return suiteName[0];
	}

	/**
	 * Get Test case
	 * @author phuong_dt
	 * @param api
	 * @param testSuiteId
	 */
	ArrayList<TestCase> getTestCase(TestLinkAPI api, Integer testSuiteId){
		ArrayList<TestCase> list = new ArrayList<TestCase>();
		TestCase[]arrTestCases;
		try {
			arrTestCases = api.getTestCasesForTestSuite(testSuiteId, true, TestCaseDetails.FULL);
			for(int i = 0; i<arrTestCases.length; i++){
				list.add(i,arrTestCases[i]);
			}
		} catch(TestLinkAPIException te) {
		}
		return list;
	}

	/**
	 * Get Test case by build
	 * @author phuong_dt
	 * @param api
	 * @param testSuiteId
	 */
	ArrayList<TestCase> getTestCaseByBuild(TestLinkAPI api, Integer testPlanId, Integer buildId){
		ArrayList<TestCase> list = new ArrayList<TestCase>();
		TestCase[]arrTestCases;
		try {
			arrTestCases = api.getTestCasesForTestPlan(testPlanId, null, buildId, null, null, null, null, null, null, null, TestCaseDetails.FULL);
			for(int i = 0; i<arrTestCases.length; i++){
				list.add(i,arrTestCases[i]);
			}
		} catch(TestLinkAPIException te) {
		}
		return list;
	}

	/**
	 * get sub test suite from test suites
	 * @param api
	 * @param testSuiteId
	 * @return
	 */
	ArrayList<TestSuite> getTestSuite(TestLinkAPI api, Integer testSuiteId){
		ArrayList<TestSuite> list = new ArrayList<TestSuite>();
		TestSuite[]arrTestSuites;
		try {
			arrTestSuites = api.getTestSuitesForTestSuite(testSuiteId);
			for(int i = 0; i<arrTestSuites.length; i++){
				list.add(i,arrTestSuites[i]);
			}
		} catch(TestLinkAPIException te) {
		}
		return list;
	}

	/**
	 * verify if testcase exist in list or not
	 * @param source
	 * @param dest
	 * @return
	 */
	public Boolean isExistTestcaseInTestBuild(TestCase source, ArrayList<TestCase> dest){
		Boolean ret = false;
		for(int i = 0; i<dest.size(); i++){
			if(source.getId().equals(dest.get(i).getId())){
				ret = true;
				break;
			}
		}
		return ret;

	}

	/**
	 * Write feature file by suiteid
	 * @author phuong_dt
	 * @param pathFile
	 * @param api
	 * @param suiteId
	 * @throws InterruptedException 
	 */
	public void generateFeatureFileBySuiteId(String pathFile,TestLinkAPI api, Integer suiteId, Integer buildId, Integer planId) throws InterruptedException{
		String suiteName=getTestSuiteById(api,suiteId).getName();
		String backGround=getTestSuiteById(api,suiteId).getDetails();
		String fs = File.separator;
		try {
			if(suiteName.contains("ElementObjectRepository")){
				generateElementObjectRepository(pathFile, api, suiteId);
			}
			if(suiteName!=null&&suiteName!=""&&!suiteName.contains("ElementObjectRepository")){
				if(getTestSuite(api,suiteId).size()==0){
					if(getTestCase(api,suiteId).size()>0)
					{
						TestLogger.info("generate feature file for feature "+suiteName+" with id ="+suiteId);
						StringBuilder stringBuilder = new StringBuilder();
						if(tagName!=""&&tagName!=null)
							stringBuilder.append("@"+tagName);
						stringBuilder.append("\n");
						stringBuilder.append("Feature: "+suiteName);
						String upperFileName=CucumberUtil.toUpper(suiteName.replace("-", " "));
						String upperPackageName=upperFileName.replaceAll("\\s","").substring(upperFileName.indexOf(":")+1).toLowerCase();
						String fileName = upperFileName.replaceAll("\\s","").substring(upperFileName.indexOf(":")+1);
						File f = new File((pathFile+"features/"
								+upperPackageName
								+"/"
								+fileName+".feature")
								.replace("/", fs).replace("\\", fs));
						if(backGround!=null && backGround!="" &&!backGround.isEmpty()){
							if(backGround.toLowerCase().contains("background:"))
								stringBuilder.append("\n"+CucumberUtil.processSpecialString(CucumberUtil.addCucumberString(CucumberUtil.processSpecialString(backGround))));
							else
								stringBuilder.append("\n"+"Background:"+"\n"+CucumberUtil.processSpecialString(CucumberUtil.addCucumberString(CucumberUtil.processSpecialString(backGround))));
						}
						ArrayList<TestCase> testCase = getTestCase(api,suiteId); 
						ArrayList<TestCase> testCase1 = getTestCaseByBuild(api, planId, buildId);
						for(int k = 0; k<testCase.size(); k++){
							if(testCase.get(k).getExecutionType().getValue()==2){
								if(isExistTestcaseInTestBuild(testCase.get(k),testCase1)==true){
									TestLogger.info("generate test case for build");
									Integer caseId = testCase.get(k).getId();
									String caseName = testCase.get(k).getName().trim();
									String caseSummary = CucumberUtil.processSpecialString(CucumberUtil.addCucumberString(CucumberUtil.processSpecialString(testCase.get(k).getSummary()).trim()));
									//String caseSummary = testCase.get(k).getSummary();
									TestLogger.info("caseName "+caseName);
									stringBuilder.append("\n#Case ID:"+ caseId);
									stringBuilder.append("\n#Case Name:"+ caseName);
									if(!caseName.contains("Scenario")){
										if(caseSummary.toLowerCase().contains("examples"))
											stringBuilder.append("\nScenario Outline: "+caseName);
										else
											stringBuilder.append("\nScenario: "+caseName);
									}
									stringBuilder .append("\n\t"+caseSummary);
								}
							}
						}
						/*if(f.exists()){
							File f1 = new File((pathFile+"features/"
									+upperPackageName
									+"/"
									+fileName+".feature")
									.replace("/", fs).replace("\\", fs)); 
							File backUpFile = new File(pathFile+CucumberUtil.getCurrentDate("yyyyMMDDHHmm")+"features/"+upperPackageName);
							f.renameTo(f1);
							CucumberUtil.copyFileToDirectory(f1,backUpFile);
							f1.delete();

							File featureFolder = new File((pathFile+"features/"));
							CucumberUtil.deleteDirectory(featureFolder);


						}*/
						FileUtils.writeStringToFile(f, stringBuilder.toString());

					}
				} 
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write feature file
	 * @author phuong_dt
	 * @param pathFile
	 * @param api
	 * @param projectName
	 */
	public void generateAllFeatureFile(String pathFile,TestLinkAPI api, String projectName, String planName, String buildName){
		ArrayList<TestSuite> testSuite;
		if(planName!="" || planName!=null)
			testSuite = getTestSuiteForTestPlan(api, planName, projectName);
		else
			testSuite = getFirstLevelTestSuite(api,projectName); 
		for(int j = 0; j<testSuite.size(); j++){
			Integer suiteId=testSuite.get(j).getId();
			try {
				TestLogger.info("Suite name is "+testSuite.get(j).getName()+" and id = "+suiteId);
				Integer buildId=getBuildIdByName(api, projectName, planName, buildName);
				Integer planId= getTestPlanId(api, planName, projectName);
				generateFeatureFileBySuiteId(pathFile,api,suiteId,buildId,planId);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * get test plan by name
	 * @author phuong_dt
	 * @param api
	 * @param planName
	 * @param projectName
	 */
	public Integer getTestPlanId(TestLinkAPI api, String planName, String projectName){
		return api.getTestPlanByName(planName, projectName).getId();
	}

	/**
	 * get build id
	 * @author phuong_dt
	 * @param api
	 * @param planName
	 * @param projectName
	 * @return
	 */
	public Integer getLatestBuildId(TestLinkAPI api, String planName, String projectName){
		Integer id = api.getLatestBuildForTestPlan(getTestPlanId(api, planName, projectName)).getId();
		TestLogger.info(String.valueOf(id));
		return id;
	}


	/**
	 * get build id
	 * @author phuong_dt
	 * @param api
	 * @param buildName
	 * @param planName
	 * @param projectName
	 * @return
	 */
	public Integer getBuildIdByName(TestLinkAPI api, String projectName, String planName, String buildName){
		Build[] arrayBuild=api.getBuildsForTestPlan(getTestPlanId(api, planName, projectName));
		Integer id = null;
		for(int i=0; i<arrayBuild.length; i++){
			if(arrayBuild[i].getName().trim().equals(buildName.trim())){
				id=arrayBuild[i].getId();
				break;
			}
		}
		TestLogger.info(buildName+" has id: "+String.valueOf(id));
		return id;
	}

	/**
	 * get platform of plan
	 * @author phuong_dt
	 * @param api
	 * @param planName
	 * @param projectName
	 * @return
	 */
	ArrayList<Platform> getPlatformOfPlan(TestLinkAPI api, String planName, String projectName){
		Integer planId=getTestPlanId(api, planName, projectName);
		ArrayList<Platform> list = new ArrayList<Platform>();
		Platform[]arrTestCases;
		try {
			arrTestCases = api.getTestPlanPlatforms(planId);
			for(int i = 0; i<arrTestCases.length; i++){
				list.add(i,arrTestCases[i]);
			}
		} catch(TestLinkAPIException te) {
		}
		return list;
	}

	/**
	 * Get test case id from testcase name
	 * @author phuong_dt
	 * @param api
	 * @param testCaseName
	 * @param testProjectName
	 * @return
	 */
	public Integer getTestCaseIdFromName(TestLinkAPI api,String testCaseName, String testProjectName){
		Integer tcid=0;
		tcid=api.getTestCaseIDByName(testCaseName, null, testProjectName, null);
		TestLogger.info("test case id is "+String.valueOf(tcid));
		return tcid;
	}

	/**
	 * report test execution to TestLink API
	 * @author phuong_dt
	 * @param api
	 * @param projectName
	 * @param planName
	 * @param tcid
	 * @param status
	 */
	public void reportTCResultToTestLink(TestLinkAPI api, String projectName,String planName, String buildName, String testCaseName, String status)
	{
		Integer tpid = getTestPlanId(api, planName, projectName);

		try 
		{
			XmlRpcClient rpcClient;
			XmlRpcClientConfigImpl config;

			config = new XmlRpcClientConfigImpl();
			config.setServerURL(new URL(url));
			rpcClient = new XmlRpcClient();
			rpcClient.setConfig(config);		

			ArrayList<Object> params = new ArrayList<Object>();
			Hashtable<String, Object> executionData = new Hashtable<String, Object>();				
			executionData.put("devKey", devKey);
			executionData.put("testcaseid", getTestCaseIdFromName(api,testCaseName,projectName));
			executionData.put("testplanid", tpid);
			if(buildName!=""&&buildName!=null)
				executionData.put("buildid", getBuildIdByName(api, buildName, planName, projectName));
			else
				executionData.put("buildid", getLatestBuildId(api,planName,projectName));
			executionData.put("status", status);
			executionData.put("platformname", platformName);
			params.add(executionData);
			Object[] result = (Object[]) rpcClient.execute("tl.reportTCResult", params);
			TestLogger.info("Result was: "+result.length);				
			for (int i=0; i< result.length; i++)
			{
				Map<?, ?> item = (Map<?, ?>)result[i];
				TestLogger.info("Keys: " + item.keySet().toString() + " values: " + item.values().toString());
			}
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (XmlRpcException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create new project on testlink
	 * @param api
	 * @param testProjectName
	 * @param testProjectPrefix
	 * @param notes
	 * @param enableRequirements
	 * @param enableTestPriority
	 * @param enableAutomation
	 * @param enableInventory
	 * @param isActive
	 * @param isPublic
	 */
	public void createProjectOnTestLink(TestLinkAPI api,
			String testProjectName, 
			String testProjectPrefix, 
			String notes, 
			Boolean enableRequirements, 
			Boolean enableTestPriority, 
			Boolean enableAutomation, 
			Boolean enableInventory, 
			Boolean isActive, 
			Boolean isPublic){
		if(isProjectPresent(api,testProjectName)){
			TestLogger.info("Project "+testProjectName+" exists");
		}
		else{
			TestLogger.info("Create one project "+testProjectName+" on testlink");
			api.createTestProject(testProjectName, testProjectPrefix, notes, enableRequirements, enableTestPriority, enableAutomation, enableInventory, isActive, isPublic);
		}
	}

	/**
	 * create new plan on testlink
	 * @param api
	 * @param planName
	 * @param projectName
	 * @param notes
	 * @param isActive
	 * @param isPublic
	 */
	public void createPlanOnTestLinK(TestLinkAPI api,
			String planName, 
			String projectName, 
			String notes, 
			Boolean isActive, 
			Boolean isPublic){
		if(isTestPlanPresent(api, projectName, planName)){
			TestLogger.info("Plan "+planName+" exists in project "+projectName);
		}
		else{
			TestLogger.info("Create one plan "+planName+" on project "+projectName+" on testlink");
			api.createTestPlan(planName, projectName, notes, isActive, isPublic);
		}
	}

	/**
	 * create one build for test plan
	 * @param api
	 * @param projectName
	 * @param planName
	 * @param buildName
	 * @param buildNotes
	 */
	public void createBuildOnTestLink(TestLinkAPI api,
			String projectName,
			String planName, 
			String buildName, 
			String buildNotes){
		TestLogger.info("Create one build "+buildName+" on project "+projectName+" on testlink");
		Integer testPlanId = getTestPlanId(api, planName, projectName);
		api.createBuild(testPlanId, buildName, buildNotes);
	}

	/**
	 * create one testsuite 
	 * @param api
	 * @param projectName
	 * @param suiteName
	 * @param details
	 * @param parentId
	 * @param order
	 * @param checkDuplicatedName
	 * @param actionOnDuplicatedName
	 */
	public Integer createSuiteOnTestLink(TestLinkAPI api,
			String projectName, 
			String suiteName,
			String details, 
			Integer parentId, 
			Integer order, 
			Boolean checkDuplicatedName, 
			ActionOnDuplicate actionOnDuplicatedName){
		TestLogger.info("Create test suite "+suiteName+" on project "+projectName+" on testlink");
		Integer testProjectId = api.getTestProjectByName(projectName).getId();
		TestSuite suite=api.createTestSuite(testProjectId, suiteName, details, parentId, order, checkDuplicatedName, actionOnDuplicatedName);
		return suite.getId();
	}

	/**
	 * create new test case
	 * @param api
	 * @param testCaseName
	 * @param planName
	 * @param testSuiteId
	 * @param projectName
	 * @param summary
	 * @param importance
	 * @param execution
	 * @param checkDuplicatedName
	 * @param actionOnDuplicatedName
	 */
	public void createTestCase(TestLinkAPI api,String testCaseName,
			String planName,
			Integer testSuiteId,
			String projectName,
			String summary,
			TestImportance importance,
			ExecutionType execution,
			Boolean checkDuplicatedName,
			ActionOnDuplicate actionOnDuplicatedName){
		TestLogger.info("Create test case "+testCaseName+" on project "+projectName+"/"+planName+"/"+testSuiteId+" on testlink");
		Integer testProjectId = api.getTestProjectByName(projectName).getId();
		api.createTestCase(testCaseName, testSuiteId, testProjectId, System.getProperty("user.name"), summary, null, null, importance, execution, null, null, true, actionOnDuplicatedName);
	}

	/**
	 * Write feature file by suiteid
	 * @author phuong_dt
	 * @param pathFile
	 * @param api
	 * @param suiteId
	 * @throws InterruptedException 
	 */
	public void generateElementObjectRepository(String pathFile,TestLinkAPI api, Integer suiteId) throws InterruptedException{
		String suiteName=getTestSuiteById(api,suiteId).getName();
		String fs = File.separator;
		try {
			File backUpFile = new File(pathFile+CucumberUtil.getCurrentDate("yyyyMMDDHHmm")+"objects/");
			File sourceFile = new File(pathFile+"objects/");
			CucumberUtil.copyDirectoryToDirectory(sourceFile,backUpFile);
			CucumberUtil.deleteDirectory(sourceFile);
			if(suiteName.contains("ElementObjectRepository")){
				if(getTestSuite(api,suiteId).size()==0){
					if(getTestCase(api,suiteId).size()>0)
					{
						TestLogger.info("generate element repository file");
						ArrayList<TestCase> testCase = getTestCase(api,suiteId); 
						for(int k = 0; k<testCase.size(); k++){
							StringBuilder stringBuilder = new StringBuilder();
							String caseName = testCase.get(k).getName().trim().replace(" ", "");
							String caseSummary = testCase.get(k).getSummary();
							File f = new File((pathFile+"objects/"
									+caseName+".properties")
									.replace("/", fs).replace("\\", fs)); 
							stringBuilder .append(caseSummary);
							FileUtils.writeStringToFile(f, stringBuilder.toString(),"UTF-8");
						}


					}
				} 
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
