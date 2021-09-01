package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/featureFiles",
		glue={"com.stepDefinnition"},
		monochrome = true,
		tags = "@DummyTest"
		)
public class TestRunner{

}
