Feature: Manage Access

  Scenario: Verify admin can add new user
    Given I navigate to Interview Prep
    Then I should see the "Login" page
    Then I enter "admin@yahoo.com" in the "Enter Username" input box
    Then I enter "adminuser123" in the "Enter Password" input box
    Then I click "Login" button
    Then I should see the "Home" page
    And I click "Manage Access" link
    Then I enter the following values in the following fields
      | First Name | John                  |
      | Last Name  | Smith                 |
      | E-mail     | john1.smith@gmail.com |
    And I choose "Student" from dropdown "Role"
    And I choose "4" from dropdown "Batch"
    And I click "Add User" button
    Then Verify the following user exists in the table
      | First Name | John                  |
      | Last Name  | Smith                 |
      | E-mail     | john1.smith@gmail.com |
      | Role       | Student               |
      | Batch      | 4                     |
    And I click "Action" button of user "john1.smith@gmail.com"
    And I click "Edit" button
    Then I edit the user with following
      | E-mail | john1.smith.new@gmail.com |
      | Role   | Mentor                    |
      | Batch  | N/A                       |
    Then I click "Update User" button
    Then Verify the following user exists in the table
      | First Name | John                      |
      | Last Name  | Smith                     |
      | E-mail     | john1.smith.new@gmail.com |
      | Role       | Mentor                    |
      | Batch      | N/A                       |
    And I click "Action" button of user "john1.smith.new@gmail.com"
    And I click "Delete" button
    And I click confirm "Delete" button
    Then Verify the following user does NOT exist in the table
      | First Name | John                      |
      | Last Name  | Smith                     |
      | E-mail     | john1.smith.new@gmail.com |
      | Role       | Mentor                    |
      | Batch      | N/A                       |