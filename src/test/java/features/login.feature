Feature: Login Feature
  Verify user ketika Login masuk ke aplikasi web hijra web

  Scenario: Login as user aktif hijra web
    Given user is on homepage
    When user navigates to Login Page
    When user enters username and Password
    Then success message is displayed
    Then logout website