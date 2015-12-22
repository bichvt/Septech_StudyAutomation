package auto.septech.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
features={"src/test/resources/features/"},
glue="auto.septech.scenariosteps",
tags = {"@Test"},
format={"pretty","junit:target/cucumber.xml"
		,"html:target"
		,"json:target/cucumber.json"})
public class TestRunner {}
