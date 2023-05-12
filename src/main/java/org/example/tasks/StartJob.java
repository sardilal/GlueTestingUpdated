package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.example.utils.aws.GlueExecutor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartJob implements Task {
    public String job;
    public StartJob (String job){
        this.job = job;
    }
    public static Performable withName(String job){
        return instrumented(StartJob.class, job);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        GlueExecutor.startJob(job);
    }
}
