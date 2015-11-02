package auto.septech.generation;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import auto.septech.testlink.CucumberUtil;
import auto.septech.testlink.TestLinkBase;
import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;

public class AllFeatureGenerationTest {

	@Test
	public void generateMultiFeatureFiles() throws IOException{
		TestLinkBase genFile = new TestLinkBase();
		genFile.getSystemProperty();
		TestLinkAPI testLinkApi = genFile.connectTestLink(TestLinkBase.url,TestLinkBase.devKey);
		File backUpFile = new File(TestLinkBase.pathFeature+CucumberUtil.getCurrentDate("yyyyMMDDHHmm")+"features/");
		File sourceFile = new File(TestLinkBase.pathFeature+"features/");
		CucumberUtil.copyDirectoryToDirectory(sourceFile,backUpFile);
		CucumberUtil.deleteDirectory(sourceFile);
		genFile.generateAllFeatureFile(TestLinkBase.pathFeature,testLinkApi,TestLinkBase.project,TestLinkBase.planName);
	}
}
