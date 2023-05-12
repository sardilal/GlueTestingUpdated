package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import org.example.utils.aws.GlueExecutor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartCrawler implements Task {

    private String crawler;
    public StartCrawler(String crawler){
        this.crawler = crawler;
    }



    public static Performable withCrawlerName(String crawler){
        return instrumented(StartCrawler.class, crawler);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        GlueExecutor.startCrawler(crawler);
    }
}
