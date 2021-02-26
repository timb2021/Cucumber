import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/DashboardRunner",
                "rerun:target/Rerun_Failed/DashboardRunner.txt"},
        features = "src/main/resources/features/dashboard.feature",
        glue = {"steps"}
        , tags = "@test"

)

public class DashboardRunner {
}