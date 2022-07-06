package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = "@ui",
        glue = {"stepDefs"},
        plugin ={"pretty", "html:target/site/cucumber-pretty",
                "json:target/jsonreports/cucumber.json",
                "summary"}
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

)
public class SmokeRunner extends AbstractTestNGCucumberTests{


    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
