package steps;

import impls.DashboardImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class DashboardSteps {
    @Then("I verify the following dashboards are displayed:")
    public void iVerifyTheFollowingDashboardsAreDisplayed(List<String> dashboardList) {
        DashboardImpl impl = new DashboardImpl();
        impl.verifyDashboards(dashboardList);
    }

    @Then("I should see {string} error message")
    public void iShouldSeeErrorMessage(String errorMessage) {
        DashboardImpl impl = new DashboardImpl();
        impl.validateErrorMsg(errorMessage);
    }

    @Then("I delete the following dashboard:")
    public void iDeleteTheFollowingDashboard(String dashName) {
        DashboardImpl impl = new DashboardImpl();
        impl.deleteDash(dashName);
    }

    @Then("I should see {string} section")
    public void iShouldSeeSection(String sectionName) {
        DashboardImpl impl = new DashboardImpl();
        impl.validateSection(sectionName);
    }

    @And("I validate {string} is displayed in {string} window")
    public void iValidateIsDisplayedInWindow(String message, String nameWindows) {
        DashboardImpl impl = new DashboardImpl();
        impl.messageIsDisplayed(message, nameWindows);
    }

    @Then("I click {string} icon button on {string} in {string} window")
    public void iClickIconButtonOnInWindow(String inconName, String message, String nameWindow) {
        DashboardImpl impl = new DashboardImpl();
        impl.clickIcon(inconName, message, nameWindow);
    }

    @And("I validate {string} is  Not displayed in {string} window")
    public void iValidateIsNotDisplayedInWindow(String message, String nameWindows) {
        DashboardImpl impl = new DashboardImpl();
        impl.messageIsNotDisplayed(message, nameWindows);
    }

}
