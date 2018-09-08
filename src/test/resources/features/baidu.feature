@Baidu
Feature: Testing

  Scenario: Open Baidu and Search "hello world"
    Given user lands on "http://www.baidu.com"
    And user inputs "hello world" in "#kw"
    When user click "#su"
    Then user should see "hello world" on the page