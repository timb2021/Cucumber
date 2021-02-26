package utils;

import io.cucumber.core.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CucumberLogUtils {

    public static Scenario currentScenario;

    public static void initScenario(Scenario scenario) {
        currentScenario = scenario;
    }

    public static void logPass(String message, boolean takeScreenshot) {
        currentScenario.write(getLogTime() + " Pass: " + message);

        if (takeScreenshot) {
            final byte[] screenshot = ((TakesScreenshot) WebdriverUtils.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            currentScenario.embed(screenshot, "image/png");
        }
    }

    public static void logFail(String message, boolean takeScreenshot) {

        if (takeScreenshot) {
            final byte[] screenshot = ((TakesScreenshot) WebdriverUtils.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            currentScenario.embed(screenshot, "image/png");
        }

        Assert.fail(getLogTime() + " FAIL: " + message);
    }

    public static String getLogTime() {
        String format = "yyyy-MM-dd HH:mm:ss";

        DateFormat dataFormate = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();

        return dataFormate.format(cal.getTime());
    }

}
