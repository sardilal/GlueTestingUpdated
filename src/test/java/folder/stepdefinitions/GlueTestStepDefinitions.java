package folder.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.example.tasks.StartCrawler;
import org.example.tasks.StartJob;

import java.util.logging.Logger;

public class GlueTestStepDefinitions {

    private static final Logger LOGGER = Logger.getLogger(GlueTestStepDefinitions.class.getName());
    private static final String USER = "lucy";

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(USER);
    }

    @Given("I run the aws glue crawler")
    public void iRunTheAwsGlueCrawler() {
        LOGGER.info("-----------> STEP 1: RUN THE AWS GLUE CRAWLER");
        OnStage.theActorInTheSpotlight().attemptsTo(StartCrawler.withCrawlerName("tutorialCrawler"));
    }

    @When("I run the aws glue Job")
    public void iRunTheAwsGlueJob(){
        LOGGER.info("--------> STEP 2: RUNNING THE AWS GLUE JOB");
        OnStage.theActorInTheSpotlight().attemptsTo(StartJob.withName("testVisual"));
    }
}
