Feature: ETL with AWS Glue
  I want to extract data with an aws glue crawler
  Transform it using an AWS Glue Job
  So i can validate it after it is loaded to an S3 Bucket

  Scenario: Transform data with glue and load it to S3
    Given I run the aws glue crawler
    When I run the aws glue Job
    Then I should see the file in the S3 Bucket