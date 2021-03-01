import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/LoginRunner",
        "rerun:target/Rerun_Failed/LoginRunner.txt"},    // Generates html report in target folder
        features = "src/main/resources/features/login.feature",   // if /features/login.feature:15 will run only scenario from line 15
        glue = {"steps"}
//        tags = "@test1 or @test2"     // if exist one of them will run (tags)
        //tags = "@test1 and @test2"    // to run need to exist both of them (tags)
        //tags = "@test3 or @test4 or @test5"
        , stepNotifications = true   // display each steps on the console
      //  , tags = "@test"
        , dryRun = false    // generate step defs

)

public class LoginRunner {

}
