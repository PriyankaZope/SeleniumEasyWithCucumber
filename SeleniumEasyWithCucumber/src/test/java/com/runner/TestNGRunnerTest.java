package com.runner;

import java.io.File;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureFiles", glue = {
						"com.stepDefinnition" },
						tags = "@DummyTest2",
						plugin = { "pretty",
				"html:target/My-ReportsHTML/cucumber-reports",
				"json:target/My-ReportsJSon/cucumber-reports/Cucumber.json",
				"junit:target/My-ReportsXml/cucumber-reports/Cucumber.xml", }, 
						dryRun = false,
						//strict=true,
						monochrome = true)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

}
