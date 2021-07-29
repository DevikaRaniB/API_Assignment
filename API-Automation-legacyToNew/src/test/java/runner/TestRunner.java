package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@CucumberOptions(features = "resources/Feature",
tags={"@APITestCase"},
glue = {"stepdefs" },
monochrome=true,
plugin = "json:target/cucumber-report-feature-composite.json")


@Test
public class TestRunner extends AbstractTestNGCucumberTests {
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
	//property file 
		//driver initialization 
	}
	
	

}



