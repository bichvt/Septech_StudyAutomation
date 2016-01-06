package auto.septech.generation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import auto.septech.testlink.FeatureUtil;
import auto.septech.testlink.TestLinkBase;
import auto.septech.utilities.TestLogger;
import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ActionOnDuplicate;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.constants.TestImportance;

public class AllFeatureCreateTestCaseOnTestLink {
	@Test
	public void ImportTestCaseToTestLink() throws IOException{
		TestLinkBase genFile = new TestLinkBase();
		FeatureUtil featureUtil = new FeatureUtil();
		genFile.getSystemProperty();
		TestLogger.info(TestLinkBase.pathFileToWriteTestLink);
		if(TestLinkBase.pathFileToWriteTestLink!=null&&!TestLinkBase.pathFileToWriteTestLink.isEmpty()){
			ArrayList<String> fileName = FeatureUtil.listFilesForFolder(TestLinkBase.pathFileToWriteTestLink);
			ArrayList<String> objectFileName = FeatureUtil.listObjectFiles(TestLinkBase.pathFileOfObject);
			TestLinkAPI testLinkApi = genFile.connectTestLink(TestLinkBase.url,TestLinkBase.devKey);
			genFile.createProjectOnTestLink(testLinkApi, TestLinkBase.project, TestLinkBase.testProjectPrefix, null, false, true, true, true, true, true);
			genFile.createPlanOnTestLinK(testLinkApi, TestLinkBase.planName, TestLinkBase.project, null, true, true);
			for(int i = 0; i<fileName.size(); i++){
				FeatureUtil.readFile(fileName.get(i));
				ArrayList<HashMap<String, String>> tcase = FeatureUtil.caseList;
				Integer suiteid=genFile.createSuiteOnTestLink(testLinkApi, TestLinkBase.project, FeatureUtil.feature, FeatureUtil.background, null, null, true, ActionOnDuplicate.CREATE_NEW_VERSION);
				for(int j = 0; j<tcase.size(); j++){
					genFile.createTestCase(testLinkApi, tcase.get(j).get("name"), TestLinkBase.planName, suiteid, TestLinkBase.project, tcase.get(j).get("summary"), TestImportance.HIGH, ExecutionType.AUTOMATED, true, ActionOnDuplicate.CREATE_NEW_VERSION);
				}
			}
			Integer suiteObjectId=genFile.getSuiteId(testLinkApi, TestLinkBase.project, TestLinkBase.planName, "ElementObjectRepository");
			if(suiteObjectId==null){
				suiteObjectId=genFile.createSuiteOnTestLink(testLinkApi, TestLinkBase.project, "ElementObjectRepository", FeatureUtil.background, null, null, true, ActionOnDuplicate.CREATE_NEW_VERSION);
			}
			for(int i = 0; i<objectFileName.size(); i++){
				TestLogger.info("generate object file");
				String content=featureUtil.readObjectFile(objectFileName.get(i));
				genFile.createTestCase(testLinkApi, objectFileName.get(i).substring(objectFileName.get(i).lastIndexOf(File.separator)+1,objectFileName.get(i).lastIndexOf(".")), TestLinkBase.planName, suiteObjectId, TestLinkBase.project, content, TestImportance.HIGH, ExecutionType.AUTOMATED, true, ActionOnDuplicate.GENERATE_NEW);
			}
		}
	}
}
