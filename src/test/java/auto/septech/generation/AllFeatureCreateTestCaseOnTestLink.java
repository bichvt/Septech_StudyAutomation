package auto.septech.generation;

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
		genFile.getSystemProperty();
		TestLogger.info(TestLinkBase.pathFileToWriteTestLink);
		if(TestLinkBase.pathFileToWriteTestLink!=null&&!TestLinkBase.pathFileToWriteTestLink.isEmpty()){
			ArrayList<String> fileName = FeatureUtil.listFilesForFolder(TestLinkBase.pathFileToWriteTestLink);
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
		}
	}
}
