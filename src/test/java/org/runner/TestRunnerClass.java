package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.ReportingClass;
import org.steps.HooksClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFile\\Luma.feature", 
                 glue = "org.steps",
                 monochrome = true ,
                 dryRun = false,
                 plugin = {"html:target\\htmlreport",
		                   "junit:target\\junitReport.xml",
		                   "json:target\\jsonReport.json"})
public class TestRunnerClass {
	

	@AfterClass
	public static void report() {
		ReportingClass.generateReport("target\\jsonReport.json");
	}
	
}
