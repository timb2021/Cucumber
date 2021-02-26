package impls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import pages.ManageAccessPage;
import utils.CucumberLogUtils;
import utils.MiscUtils;
import utils.WebdriverUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManageAccessImpl {

    public void clickLink(String linkName) {
        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_LINK, linkName);
        WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));
        MiscUtils.highlightElement(element).click();
        MiscUtils.sleep(1000);

        CucumberLogUtils.logPass(linkName + " link was successfully clicked ", true);
    }

    public void enterValueInFields(Map<String, String> map) {

        for (String each : map.keySet()) {

            String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_INPUT_BOX, each);
            WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));

            element.sendKeys(map.get(each));

            CucumberLogUtils.logPass(map.get(each) + " was entered in " + each + " field", true);
        }

    }


    public void chooseDropdown(String selectName, String dropName) {

        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_SELECT, dropName);
        WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));

        Select select = new Select(element);
        select.selectByVisibleText(selectName);

        CucumberLogUtils.logPass(selectName + " was chosen from " + dropName + " dropdown", true);

    }

    public void verifyUserExistTable(Map<String, String> userDetails) {

        List<String> userDetailList = new ArrayList<>(userDetails.values());
        boolean exists = ifUserExists(userDetailList);
        if (exists) {
            CucumberLogUtils.logPass("The user exists", true);
        } else {
            CucumberLogUtils.logFail("The user does NOT exist", false);
        }

    }

    public void validateUserDoesNotExist(Map<String, String> userDetails) {
        List<String> userDetailList = new ArrayList<>(userDetails.values());
        boolean exists = ifUserExists(userDetailList);
        if (!exists) {
            CucumberLogUtils.logPass("The user does not exist as expected", true);
        } else {
            CucumberLogUtils.logFail("The user exists", true);
        }
    }


    private boolean ifUserExists(List<String> userDetailList) {
        MiscUtils.sleep(5000);
        List<WebElement> webElementsList = WebdriverUtils.getWebDriver().findElements(By.xpath(ManageAccessPage.XPATH_TABLE_ROWS));
        int rowCount = webElementsList.size();


        //Row loop
        for (int i = 1; i <= rowCount; i++) {
            List<String> eachRowData = new ArrayList<>();
            //Cell loop
            for (int j = 1; j <= 5; j++) {
                String cellXpath = String.format(CommonPage.XPATH_TEMPLATE_CELL, i, j);
                String cellText = WebdriverUtils.getWebDriver().findElement(By.xpath(cellXpath)).getText();
                eachRowData.add(cellText);
            }
            boolean exists = userDetailList.equals(eachRowData);
            if (exists) {
                CucumberLogUtils.logPass("The user exists in row " + i, false);
                return true;
            }
        }


        return false;
    }


//    public void verifyUserExistTable(Map<String, String> map) {
//
//        List<WebElement> rowElement = WebdriverUtils.getWebDriver().findElements(By.xpath("//tr[*]"));
//        int row = 0;
//        for (int i = 0; i < rowElement.size(); i++) {
//            if (rowElement.get(i).getText().contains(" " + map.get("E-mail") + " ")) {
//                row = i;
//            } else {
////                System.out.println("No exist");
//
//            }
//        }
//
//        List<WebElement> eachRowElement = WebdriverUtils.getWebDriver().findElements(By.xpath("//tbody//tr[" + row + "]//td"));
//        eachRowElement.remove(eachRowElement.size() - 1);
//        for (int i = 0; i < eachRowElement.size(); i++) {
//        }
//
//        int i = 0;
//        for (String each : map.keySet()) {
//
//
//            if (map.get(each).equals(eachRowElement.get(i).getText())) {
//                MiscUtils.highlightElement(eachRowElement.get(i));
//                CucumberLogUtils.logPass(each + " " + map.get(each) + " exist in the table", false);
//            } else {
//                CucumberLogUtils.logFail(each + " " + map.get(each) + " is not exist in the table", true);
//            }
//            i++;
//        }
//
//        MiscUtils.highlightElement(rowElement.get(row));
//        CucumberLogUtils.logPass("Added user " + map.get("First Name") + " " + map.get("Last Name") + " "
//                + " exists in the table", true);
//
//    }

    public void clickUserButton(String buttonName, String userName) {
        List<WebElement> rowElement = WebdriverUtils.getWebDriver().findElements(By.xpath("//tr[*]"));
        int row = 0;
        for (int i = 0; i < rowElement.size(); i++) {
            if (rowElement.get(i).getText().contains(" " + userName + " ")) {
                row = i;
            }
        }

        WebElement actionButton = WebdriverUtils.getWebDriver().findElement(By.xpath("(//button[text()='" + buttonName + "'])[" + row + "]"));

        MiscUtils.highlightElement(actionButton).click();
        CucumberLogUtils.logPass(buttonName + " button on " + userName + " was successfully clicked", true);
    }

    /*


        public void clickAction(String buttonName, String email) {
        if(email.equals("*") && buttonName.equals("*")){
          CucumberLogUtils.logFail("Invalid entry, cannot accept wild card", false);
        }
        String elementXpath = String.format(CommonPage.XPATH_TEMPLATE_USER_BUTTON,email, buttonName );
        WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath(elementXpath));
        element.click();
        CucumberLogUtils.logPass("Successfully clicked the button " + buttonName + " for " + email, false);
     }



     */


    public void editValueInFields(Map<String, String> map) {

        WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath("(//input[@id='Email'])[2]"));
        element.clear();
        element.sendKeys(map.get("E-mail"));
        CucumberLogUtils.logPass(map.get("E-mail") + " was entered in  field", true);

        Select select = new Select(WebdriverUtils.getWebDriver().findElement(By.xpath("(//select[@id='Role'])[2]")));
        select.selectByVisibleText(map.get("Role"));
        CucumberLogUtils.logPass(map.get("Role") + " was entered in  field", true);

        select = new Select(WebdriverUtils.getWebDriver().findElement(By.xpath("(//select[@id='Batch'])[2]")));
        select.selectByVisibleText((map.get("Batch")));
        CucumberLogUtils.logPass(map.get("Batch") + " was entered in  field", true);

    }

    public void confirmClickButton(String buttonName) {
        WebElement element = WebdriverUtils.getWebDriver().findElement(By.xpath("//div[@class='modal-content']//button[text()='Delete']"));
        MiscUtils.highlightElement(element).click();
        CucumberLogUtils.logPass(buttonName + " button was successfully clicked ", true);
    }

//    public void verifyUserNotExistTable(Map<String, String> map) {
//        List<WebElement> rowElement = WebdriverUtils.getWebDriver().findElements(By.xpath("//tr[*]"));
//
//        for (int i = 1; i < rowElement.size(); i++) {
//            if ((rowElement.get(i).getText().contains(" " + map.get("E-mail") + " "))) {
//                CucumberLogUtils.logPass("Deleted User " + map.get("First Name") + " " + map.get("Last Name") + " "
//                        + " is exist in the table", true);
//            } else {
//
//                CucumberLogUtils.logPass("Deleted User " + map.get("First Name") + " " + map.get("Last Name") + " "
//                        + " is NOT exist in the table", true);
//            }
//        }
//    }
}
