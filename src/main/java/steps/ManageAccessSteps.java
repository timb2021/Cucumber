package steps;

import impls.ManageAccessImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.Map;

public class ManageAccessSteps {

    @Then("I click {string} link")
    public void i_click_link(String linkName) {
        ManageAccessImpl impl = new ManageAccessImpl();
        impl.clickLink(linkName);
    }

    @Then("I enter the following values in the following fields")
    public void iEnterTheFollowingValuesInTheFollowingFields(Map<String, String> map) {
        ManageAccessImpl impl = new ManageAccessImpl();
        impl.enterValueInFields(map);
    }

    @And("I choose {string} from dropdown {string}")
    public void iChooseFromDropdown(String selectName, String dropName) {
        ManageAccessImpl impl = new ManageAccessImpl();
        impl.chooseDropdown(selectName, dropName);
    }

    @Then("Verify the following user exists in the table")
    public void verifyTheFollowingUserExistsInTheTable(Map<String, String> map) {
        ManageAccessImpl impl = new ManageAccessImpl();
        impl.verifyUserExistTable(map);
    }

    @And("I click {string} button of user {string}")
    public void iClickButtonOfUser(String buttonName, String userName) {
        ManageAccessImpl impl = new ManageAccessImpl();
        impl.clickUserButton(buttonName, userName);
    }

    @Then("I edit the user with following")
    public void iEditTheUserWithFollowing(Map<String, String> map) {
        ManageAccessImpl impl = new ManageAccessImpl();
        impl.editValueInFields(map);
    }

    @And("I click confirm {string} button")
    public void iClickConfirmButton(String buttonName) {
        ManageAccessImpl impl = new ManageAccessImpl();
        impl.confirmClickButton(buttonName);
    }

    @Then("Verify the following user does NOT exist in the table")
    public void verifyTheFollowingUserDoesNOTExistInTheTable(Map<String, String> map) {
        ManageAccessImpl impl = new ManageAccessImpl();
        impl.validateUserDoesNotExist(map);
    }
}
