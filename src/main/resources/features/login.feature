Feature: Login

  Background:
    Given I navigate to Interview Prep
    Then I should see the "Login" page


  Scenario: opening the page
    Then I enter "test@yahoo.com" in the "Enter Username" input box
    Then I enter "testuser123" in the "Enter Password" input box
    And I click "Login" button
    Then I should see the "Home" page
    Then I click "Coding" button
    Then I click "Enter new question" button

#    Create Scenario Outline which checks if the test user and admin user can successfully login

  Scenario Outline: Verify <user> can login to HomePage
    Then I enter "<email>" in the "Enter Username" input box
    Then I enter "<password>" in the "Enter Password" input box
    And I click "Login" button
    Then I should see the "Home" page

    Examples:
      | user  | email           | password     |
      | test  | test@yahoo.com  | testuser123  |
      | admin | admin@yahoo.com | adminuser123 |


  Scenario: Validate the dashboards
    Then I enter "test@yahoo.com" in the "Enter Username" input box
    Then I enter "testuser123" in the "Enter Password" input box
    And I click "Login" button
    Then I should see the "Home" page
    Then I verify the following dashboards are displayed:
      | All Topics  |
      | Coding      |
      | Soft skills |
      | Cucumber    |
      | Java        |
      | Jmeter      |
      | API         |
      | SQL         |
      | Github      |


  Scenario: Login with invalid credentials - invalid email
    Then I enter "test@gmail.com" in the "Enter Username" input box
    Then I enter "testuser123" in the "Enter Password" input box
    And I click "Login" button
    Then I should see "Incorrect username/password" error message
    Then I should see the "Login" page


  Scenario: Login with invalid credentials - invalid password
    Then I enter "test@yahoo.com" in the "Enter Username" input box
    Then I enter "testinvalid" in the "Enter Password" input box
    And I click "Login" button
    Then I should see "Incorrect username/password" error message
    Then I should see the "Login" page

  @test
  Scenario: Login with invalid credentials - empty fields
    And I click "Login" button
    Then I should see "Incorrect username/password" error message
    Then I should see the "Login" page
