package auto.testing.webapp.cucumber;

import java.io.IOException;

import org.junit.Test;
import auto.testing.webapp.testlink.TestLinkBase;
import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;

public class AllFeatureGenerationTest {

	@Test
	public void generateMultiFeatureFiles() throws IOException{
		TestLinkBase genFile = new TestLinkBase();
		genFile.getSystemProperty();
		TestLinkAPI testLinkApi = genFile.connectTestLink(TestLinkBase.url,TestLinkBase.devKey);
		genFile.generateAllFeatureFile(TestLinkBase.pathFeature,testLinkApi,TestLinkBase.project,TestLinkBase.planName);
	}
}
