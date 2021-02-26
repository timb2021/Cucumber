package impls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.LoginPage;
import utils.CucumberLogUtils;
import utils.LocalConfigUtils;
import utils.MiscUtils;
import utils.WebdriverUtils;

public class LoginImpl {

    private LoginPage loginPage;

    private LoginPage getPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(WebdriverUtils.getWebDriver());
        }
        return loginPage;
    }

    public void navigateToPage() {
        String url = LocalConfigUtils.getProperty("url");
        WebdriverUtils.getWebDriver().get(url);
        CucumberLogUtils.logPass("Successfully navigated to the url", false);
    }

    public void validateCurrentPage(String pageName) {
        boolean pageIsDisplayed = false;

        switch (pageName.toLowerCase()) {
            case "login":
                pageIsDisplayed = getPage().emailInputBox.isDisplayed();
                break;
            case "home":
                pageIsDisplayed = getPage().doNotHeader.isDisplayed();
                break;
        }

        if (pageIsDisplayed) {
            CucumberLogUtils.logPass(pageName + " page is displayed.", true);
        } else {
            CucumberLogUtils.logPass(pageName + "page is NOT displayed", true);
        }

    }

    public void enterInInputBox(String value, String inputBoxName) {
        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_INPUT_BOX, inputBoxName);
        WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));

        element.sendKeys(value);

        CucumberLogUtils.logPass(value + " was entered in " + inputBoxName + " input box successfully", true);
    }

    //archiving: because it works for only certain inputs
//    public void enterInInputBox(String value, String inputBoxName) {
//        switch (inputBoxName.toLowerCase()) {
//            case "email" :
//                getPage().emailInputBox.sendKeys(value);
//                break;
//            case "password" :
//                getPage().passwordInputBox.sendKeys(value);
//                break;
//        }
//
//        CucumberLogUtils.logPass(value + " was entered in " + inputBoxName + " input box successfully", true);
//
//    }

    public void clickButton(String buttonName) {
        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_BUTTON, buttonName);
        WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));
        MiscUtils.highlightElement(element).click();
        MiscUtils.sleep(500);
        CucumberLogUtils.logPass(buttonName + " button was successfully clicked ", true);
    }


    //archiving: because it clicks ONLY login button
//
//    public void clickLoginButton(String buttonName) {
//        switch (buttonName.toLowerCase()) {
//            case "login" :
//               WebElement webElement = getPage().loginButton;
////                MiscUtils.highlightElement(webElement);
////                webElement.click();
//                MiscUtils.highlightElement(webElement).click();
//                break;
//
//        }
//
//        CucumberLogUtils.logPass(buttonName + " button was successfully clicked ", true);
//    }
}
