package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"C:\\Users\\Preety Sehrawat\\Desktop\\Testing frameworks\\TestNGFramework\\com.cucumber.junit\\src\\test\\java\\feature\\NewFeaturefile.feature"},
glue= {"stepdefinition"})
public class testrunner {

}
