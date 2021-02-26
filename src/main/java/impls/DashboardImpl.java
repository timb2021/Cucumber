package impls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utils.CucumberLogUtils;
import utils.MiscUtils;
import utils.WebdriverUtils;

import java.util.List;

public class DashboardImpl {

    public void verifyDashboards(List<String> dashList) {

        for (String eachDashboard : dashList) {

            String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_BUTTON, eachDashboard);


            try {
                WebElement webElement = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));
                if (webElement.isDisplayed()) {
                    CucumberLogUtils.logPass(eachDashboard + " dashboard is displayed as expected.", false);
                }
            } catch (Exception e) {
                CucumberLogUtils.logFail(eachDashboard + " dashboard is NOT displayed", false);
            }

        }
        CucumberLogUtils.logPass("All the dashboards are displayed as expected: " + dashList, true);
    }

    public void validateErrorMsg(String errorMessage) {

        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_TEXT, errorMessage);
        WebElement webElement = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));

        if(webElement.isDisplayed())
        {
            //MiscUtils.highlightElement(webElement);
            CucumberLogUtils.logPass("'" + errorMessage + "' is displayed as expected " ,true);
        }
    }

    public void deleteDash(String dashName) {

        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_DELETE_DASHBAORD_BUTTON, dashName);
        WebElement webElement = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));

        if(webElement.isDisplayed())
        {
            webElement.click();

            String delete = String.format(CommonPage.XPATH_TEMPLATE_BUTTON, "Delete");
            WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath(delete));
            MiscUtils.highlightElement(element).click();

            CucumberLogUtils.logPass(dashName + " dashboard was deleted! " ,true);
        }

    }

    public void validateSection(String sectionName) {
        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_TEXT, sectionName);
        WebElement webElement = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));

        if(webElement.isDisplayed())
        {
            Actions action = new Actions(WebdriverUtils.getWebDriver());
            action.moveToElement(webElement).perform();
            MiscUtils.highlightElement(webElement);
            CucumberLogUtils.logPass("'" + sectionName + "' is displayed as expected " ,true);
        }
    }

    public void validMessageWind(String message, String nameWindows) {

    List<WebElement> listMessage = WebdriverUtils.getWebDriver().findElements(By.xpath("(//div[@class='anyClass'])[1]"));

    }
}
