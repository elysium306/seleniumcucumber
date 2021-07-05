package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:Reports/htmlReport.html",
		"json:Reports/jsonReport.json"},
		features="./src/test/resources/features",
		glue="step_definitions",
		dryRun=false,
<<<<<<< HEAD
		tags="@addTradeWithDatatable"
=======
		tags="@SauceInvalidLogin"
>>>>>>> c33237d5d93a1b22677ef803f75c38a3843b69f5
		)
public class TestRunner {
	
	//dryRun = we are telling to cucumber to run only the scenario steps, not the implementation

}