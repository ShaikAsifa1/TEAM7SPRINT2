package demoblaze;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions
(plugin = {"pretty", "junit:target/report.xml",},
tags="@ParameterizedTest",
features="C:\\Users\\shivr\\eclipse-workspace\\BDDdemoblaze_07\\src\\test\\java\\demoblaze\\demoblaze.feature",
glue="demoblaze",
monochrome=true,
dryRun=false
)
//"html:target/Destination",
//"json:target/report.json"
public class demoblazeRunner {

}
