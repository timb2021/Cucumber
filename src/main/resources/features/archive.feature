#Feature: Login
##deature file steps (steps)
##  Background:
##    Given I navigate to Interview Prep
##    Then I should see the login page
#
#  @test1
#  Scenario: Login as test user
#    Then I enter "test@yahoo.com" in the Email input box
#    And I enter "testUserPassword" in the Password input box
#    And I click "Login" button
#    Then I validate I am on "Interview prep home" page
#
#  @test2
#  Scenario: Login as admin user
#    Then I enter "admin@yahoo.com" in the Email input box
#    And I enter "adminUserPassword" in the Password input box
#    And I click "Login" button
#    Then I validate I am on "Interview prep home" page
#
#  @test3 @test1 @regression @shakeout @miniregression
#  Scenario: Login with invalid credentials - invalid email
#    Then I enter "test@gmail.com" in the Email input box
#    And I enter "test123" in the Password input box
#    And I click "Login" button
#    Then I should see a "Incorrect username/password" error message
#    Then I validate I am on "Login" page
#
#  @test4
#  Scenario: Login with invalid credentials - invalid password
#    Then I enter "test@yahoo.com" in the Email input box
#    And I enter "testinvalid" in the Password input box
#    And I click "Login" button
#    Then I should see a "Incorrect username/password" error message
#    Then I validate I am on "Login" page
#
#  @test5
#  Scenario: Login with invalid credentials - empty fields
#    And I click "Login" button
#    Then I should see a "Incorrect username/password" error message
#    Then I validate I am on "Login" page
#
#
#  Scenario Outline: Open browser
#
#    Given  I open "<browserType>" browser
#
#    Examples:
#      | browserType |
#      | Chrome      |
#      | Firefox     |
#      | IE          |
#
#
#  Scenario Outline: login as "<user>"
#    Then I enter "<email>" in the email box
#    Then I enter "<password>" in the password box
#    And I click "Login" button
#    Then I validate I am on "Interview Prep home" page
#
#
#    Examples:
#      | user       | email                | password          |
#      | test       | test@yahoo.com       | testUserPassword       |
#      | admin      | admin@yahoo.com      | adminUserPassword      |
#      | manager    | manager@yahoo.com    | manageruser123    |
#      | Instructor | instructor@yahoo.com | instructoruser123 |
#      | mentor     | mentor@yahoo.com     | mentoruser123     |
#
#
#  @testLogin
#  Scenario: opening the page
#    Given I navigate to Interview Prep
#
#
#
#
#
#
#
#   #As a user, I want to have a login page so I can navigate to the home page
#
#
#
#
##(Gherkin)
##Given
##Then
##When
##And
##But
#
#
##  --------------- dashboard.feature -----------------------
#
#  # As a general user I want to have dashboards displayed on the homepage.
#
##  @test1
##  Scenario: Validate all the dashboard names
##    Given I navigate to Interview Prep
##    Then I should see the login page
##    Then I enter "test@yahoo.com" in the Email input box
##    And I enter "testUserPassword" in the Password input box
##    And I click "Login" button
##    Then I validate the following incons on the dashboard
##      | All topics  |
##      | Coding      |
##      | Soft skills |
##      | Cucumber    |
##      | Java        |
##      | Selenium    |
##      | Jmeter      |
#
#
#
#
#
#  #when the user clicks on each dashboard icon, the user should be directed to the dashboard
#
#  @Testout
#  Scenario Outline: Validate all dashboard pages
#    Given I navigate to Interview Prep
#    Then I should see the login page
#    Then I enter "test@yahoo.com" in the Email input box
#    And I enter "testUserPassword" in the Password input box
#    And I click "Login" button
#    Then I validate I am on "Interview Prep home" page
#    Then I click on "<allDash>" dash board
#    Then I validate I am on the "<allDash>" page
#
#    Examples:
#      | allDash    |
#      | All topics |
#      | Cucumber   |
#      | SQL        |
#      | Others     |
#      | Java       |
#      | JMeter     |
#
#
#  Scenario Outline: Validate all dashboard pages have an option to add anew question
#
#    Given I navigate to Interview Prep
#    Then I should see the login page
#    Then I enter "test@yahoo.com" in the Email input box
#    And I enter "testUserPassword" in the Password input box
#    And I click "Login" button
#    Then I validate I am on "Interview Prep home" page
#    Then I click "<icon>"
#    Then I validate I am on "<icon>" page
#    Then I click "Enter new question" button
#    Then I enter "What is JAVA?" in "Your question" input
#    Then I click "Enter" button
#    Then I validate "What is JAVA?" question displayed
#    Then I validate question "What is JAVA?" has datestamp
#    Examples:
#      |icon      |
#      |Coding    |
#      |Java      |
#      |Selenium  |
#      |Jmeter    |
#
#
##    -------------------- ManageAccess.feature ---------------
#
#  @test1
#  Scenario: Validate new user form
#    Given I navigate to Interview Prep
#    Then I should see the login page
#    Then I enter "admin@yahoo.com" in the Email input box
#    And I enter "adminUserPassword" in the Password input box
#    And I click "Login" button
#    Then I validate I am on "Interview prep home" page
#    And I click "Manage Access" button
#    Then I validate the following "input" fields
#      | First Name |
#      | Last Name  |
#      | E-mail     |
#    Then I validate the following "dropdown" fields
#      | Role  |
#      | Batch |
#    Then I validate the following option are displayed in "Role" dropdown
#      | Student    |
#      | Instructor |
#      | E-Mentor   |
#    Then I validate the following option are displayed in "Batch" dropdown
#      | N/A |
#      | 1   |
#      | 2   |
#      | 3   |
#      | 4   |
#      | 5   |
#      | 6   |
#      | 7   |
#      | 8   |
#      | 9   |
#      | 10  |
#
##    Then I validate the following table
##     ...
#
#  @createuser
#  Scenario: create a new user
#    Given I navigate to Interview Prep
#    Then I should see the login page
#    Then I enter "admin@yahoo.com" in the Email input box
#    And I enter "adminUserPassword" in the Password input box
#    And I click "Login" button
#    Then I validate I am on "Interview prep home" page
#    And I click "Manage Access" button
#    Then I enter the following values in the following fields
#      | First Name | John                 |
#      | Last Name  | Smith                |
#      | Email      | john.smith@gmail.com |
#      | Role       | Student              |
#      | Bath       | 4                    |
#    And I click "Add User" button
#    Then Verify the following user exists in the table
#      | First Name | John                 |
#      | Last Name  | Smith                |
#      | Email      | john.smith@gmail.com |
#      | Role       | Student              |
#      | Bath       | 4                    |
#    And I click "Action" button
#    And I click "Edit" button
#    Then I edit the user with following
#      | Email | john.smith@gmail.com |
#      | Role  | Mentor               |
#      | Bath  | N/A                  |
#    Then I click "Update user" button
#    Then Verify the following user exists in the table
#      | First Name | John                 |
#      | Last Name  | Smith                |
#      | Email      | john.smith@gmail.com |
#      | Role       | Mentor               |
#      | Bath       | N/A                  |
#
#  @test3
#  Scenario: Practice map entry
#    Then I pick the key of "Student"
#      | First Name | John                 |
#      | Last Name  | Smith                |
#      | Email      | john.smith@gmail.com |
#      | Role       | Student              |
#      | Bath       | 4                    |
#
#  Scenario Outline: Admin user <role>
#    Given I navigate to Interview Prep
#    Then I should see the login page
#    Then I enter "admin@yahoo.com" in the Email input box
#    And I enter "adminUserPassword" in the Password input box
#    And I click "Login" button
#    Then I validate I am on "Interview prep home" page
#    And I click "Manage Access" button
#    Then I enter "<firstname>" in the firstname input
#    Then I enter "<lastname>" in the lastname input
#    Then I enter "<email>" in the email input
#    Then I enter "<role>" in the role input
#    Then I enter "<batch>" in the batch input
#    And I click "Add User" button
#    Then verify the following user exists in the table
#      | First name | <firstname> |
#      | Last name  | <lastname>  |
#      | Email      | <email>     |
#      | Role       | <role>      |
#      | Batch      | <batch>     |
#
#    Examples:
#
#      | firstname | lastname | email        | role       | batch |
#      | John      | Smith    | js@yahoo.com | Instructor | N/A   |
#      | John      | Smith    | js@yahoo.com | Student    | 1     |
#      | John      | Smith    | js@yahoo.com | Mentor     | N/A   |