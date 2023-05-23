package co.com.bancolombia.rds.glue.tasks;

import co.com.bancolombia.rds.glue.utils.aws.GlueExecutor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartJob implements Task {
    public String job;

    public StartJob(String job) {
        this.job = job;
    }

    public static Performable withName(String job) {
        return instrumented(StartJob.class, job);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        GlueExecutor.startJob(job);
    }
}
