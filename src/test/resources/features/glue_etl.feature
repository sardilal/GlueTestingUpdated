@SDK
Feature: Testing AWS SDK with Glue and RDS
  As a developer, I want to test the AWS SDK with Glue and RDS tools to filter information and store it in a database.

  @TestCase1
  Scenario Outline: Make a successful data transformation with AWS Glue and store it in an RDS database
    Given I run the AWS Glue crawler <crawler>
    When I run the Glue Job <job> to apply the filters and store the data in an RDS database
    Then I should be able to verify that the filtered data has been successfully stored in the RDS database.

    Examples:
      | crawler         | job        |
      | tutorialCrawler | testVisual |
