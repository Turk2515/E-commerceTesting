package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        plugin = {"pretty", "html:target/cucumber.html",
        "json:target/cucumber.json",
        "json:target/cucumber-report/cucumber.json",
        "junit:target/cukes.xml",
        "rerun:target/rerun.txt"},
        glue = {"stepDefinitions"},
        tags = "regression",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.UNDERSCORE

)

public class TestRunner {
    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(com.example.class);
//
//        for (Failure failure : result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//
//        System.out.println(result.wasSuccessful());
//    }
    }}


