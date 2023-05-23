package co.com.bancolombia.rds.glue.stepdefinitions;

import co.com.bancolombia.rds.glue.exceptions.AssertionException;
import co.com.bancolombia.rds.glue.questions.ValidateResult;
import co.com.bancolombia.rds.glue.tasks.StartCrawler;
import co.com.bancolombia.rds.glue.tasks.StartJob;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.logging.Logger;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GlueTestStepDefinitions {
    private static final Logger LOGGER = Logger.getLogger(GlueTestStepDefinitions.class.getName());
    private static final String USER = "lucy";

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(USER);
    }

    @Given("^I run the AWS Glue crawler (.*)$")
    public void iRunTheAWSGlueCrawler(String crawler) {
        LOGGER.info("-----------> STEP 1: RUN THE AWS GLUE CRAWLER");
        theActorInTheSpotlight().attemptsTo(StartCrawler.withCrawlerName(crawler));
    }

    @When("^I run the Glue Job (.*) to apply the filters and store the data in an RDS database$")
    public void iRunTheGlueJobToApplyTheFiltersAndStoreTheDataInAnRDSDatabase(String job) {
        LOGGER.info("--------> STEP 2: RUNNING THE AWS GLUE JOB");
        theActorInTheSpotlight().attemptsTo(StartJob.withName(job));
    }

    @Then("I should be able to verify that the filtered data has been successfully stored in the RDS database.")
    public void iShouldBeAbleToVerifyThatTheFilteredDataHasBeenSuccessfullyStoredInTheRDSDatabase() {
        LOGGER.info("--------> STEP 3: ");
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateResult.list())
                .orComplainWith(AssertionException.class, "The processed result don't match with expected result."));
    }


}
