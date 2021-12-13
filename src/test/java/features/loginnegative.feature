Feature: Login Feature
  Verify user ketika Login masuk ke aplikasi web hijra web

  Scenario: Login as user aktif hijra web
    Given user is not on homepage
    When user not navigates to Login Page
    When user enters wrong username and Password
    Then not success message is displayed