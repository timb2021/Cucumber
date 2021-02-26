package impls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.DashboardPage;
import utils.CucumberLogUtils;
import utils.MiscUtils;
import utils.WebdriverUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

        if (webElement.isDisplayed()) {
            //MiscUtils.highlightElement(webElement);
            CucumberLogUtils.logPass("'" + errorMessage + "' is displayed as expected ", true);
        }
    }

    public void deleteDash(String dashName) {

        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_DELETE_DASHBAORD_BUTTON, dashName);
        WebElement webElement = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));

        if (webElement.isDisplayed()) {
            webElement.click();

            String delete = String.format(CommonPage.XPATH_TEMPLATE_BUTTON, "Delete");
            WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath(delete));
            MiscUtils.highlightElement(element).click();

            CucumberLogUtils.logPass(dashName + " dashboard was deleted! ", true);
        }

    }

    public void validateSection(String sectionName) {
        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_TEXT, sectionName);
        WebElement webElement = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));

        if (webElement.isDisplayed()) {
            Actions action = new Actions(WebdriverUtils.getWebDriver());
            action.moveToElement(webElement).perform();
            MiscUtils.highlightElement(webElement);
            CucumberLogUtils.logPass("'" + sectionName + "' is displayed as expected ", true);
        }
    }


    private Map<Boolean, Integer> ifMessageExist(String message, String nameWindows) {
        int location = 0;
        Map<Boolean, Integer> map = new LinkedHashMap<>();
        List<WebElement> listMessage;

        if (nameWindows.equals("Do's")) {
            listMessage = WebdriverUtils.getWebDriver().findElements(By.xpath(DashboardPage.XPATH_DOS));
        } else {
            listMessage = WebdriverUtils.getWebDriver().findElements(By.xpath(DashboardPage.XPATH_DONTS));
        }

        for (int i = 0; i < listMessage.size(); i++) {
            boolean exists = listMessage.get(i).getText().equals(message);
            location = i;
            if (exists) {
                map.put(exists, location);
                return map;
            }
        }
        map.put(false, -1);
        return map;
    }

    public void messageIsDisplayed(String message, String nameWindows) {
        Map<Boolean, Integer> map;
        map = ifMessageExist(message, nameWindows);

        Boolean exists = map.containsKey(true);

        if (exists) {
            CucumberLogUtils.logPass("The message " + message + " is displayed in " + nameWindows, true);
        } else {
            CucumberLogUtils.logFail("The message " + message + " is NOT displayed in " + nameWindows, false);
        }
    }

    public void messageIsNotDisplayed(String message, String nameWindows) {
        Map<Boolean, Integer> map;
        map = ifMessageExist(message, nameWindows);

        Boolean exists = map.containsKey(true);

        if (!exists) {
            CucumberLogUtils.logPass("The message " + message + " is NOT displayed in " + nameWindows, true);
        } else {
            CucumberLogUtils.logFail("The message " + message + " is displayed in " + nameWindows, false);
        }
    }

    public void clickIcon(String inconName, String message, String nameWindow) {

        Map<Boolean, Integer> map = ifMessageExist(message, nameWindow);

        int location = map.get(true);
        WebElement webElement;

        if (nameWindow.equals("Do's")) {

            webElement = WebdriverUtils.getWebDriver().findElement(By.xpath("((//div[@class='anyClass'])[1]//button[@class=\"btn btn-outline-danger ml-1\"])[" + location + "]"));
        } else {
            location = location + 1;

            webElement = WebdriverUtils.getWebDriver().findElement(By.xpath("((//div[@class='anyClass'])[2]//button[@class=\"btn btn-outline-danger ml-1\"])[" + location + "]"));
        }
        MiscUtils.highlightElement(webElement).click();
        CucumberLogUtils.logPass(inconName + " icon button was successfully clicked", true);
    }

}