package com.mscorp.StepDefs;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json"
},features="src/test/resources/features/story_007.feature")

public class RunSingleFile{
	
	
	
	
	
}	
