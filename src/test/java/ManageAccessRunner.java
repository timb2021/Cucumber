import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/ManageAccessRunner",
        "rerun:target/Rerun_Failed/ManageAccessRunner.txt"},
        features = "src/main/resources/features/manageAccess.feature",
//        features = "@target/Rerun_Failed/ManageAccessRunner.txt",
        glue = {"steps"}
        , stepNotifications = true
        , dryRun = false
//        , tags = "@test3"

)

public class ManageAccessRunner {
}
