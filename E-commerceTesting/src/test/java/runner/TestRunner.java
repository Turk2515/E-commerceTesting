package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.matchers.JUnitMatchers;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import stepDefinitions.Login;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = {"stepDefinitions"},
        tags = "regression"
)

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Login.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
    }


