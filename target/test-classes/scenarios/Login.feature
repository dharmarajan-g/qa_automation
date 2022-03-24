Feature:To login to portal

  @Test
  Scenario Outline: Basic Login Test
    Given user launches the url
    And user logs in to portal with username "<username>" and password "<password>"
    Then user validates message "Epic sadface: Sorry, this user has been locked out." on the login page

    Examples:
      | username        | password     |
      | locked_out_user | secret_sauce |