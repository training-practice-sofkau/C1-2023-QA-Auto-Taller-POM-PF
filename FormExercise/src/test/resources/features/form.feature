Feature: Fill a form
  As: DEMOQA Administrator
  I want: go to form to add students to a list
  So that

  Scenario: Successful registration
    Given Administrator was on main page
    When Navigate to form option
    And Complete fields with student's information
    Then A window with a thanks message will be displayed