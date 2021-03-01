import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/LoginRunner",
                "rerun:target/Rerun_Failed/LoginRunner.txt"},
        features = "src/main/resources/features/excel.feature",
        glue = {"steps"}
        , stepNotifications = true   // display each steps on the console
        , dryRun = false    // generate step defs

)

public class ExcelRunner {
}
