package com.mscorp.StepDefs;

import org.junit.runner.RunWith;

import com.mscorp.test.ExtendedCucumberRunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(plugin = { "html:target/cucumber-html-report", "json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt",
		"usage:target/cucumber-usage.json" }, features = "src/test/resources/features",tags = {"@altoro,@bing"})

@RunWith(ExtendedCucumberRunner.class)
public class RunFeatureFile {
}