package co.com.bancolombia.rds.glue.questions;

import co.com.bancolombia.rds.glue.models.Persons;
import co.com.bancolombia.rds.glue.utils.SqlRdsExecutor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static co.com.bancolombia.rds.glue.utils.Constants.*;

public class ValidateResult implements Question<Boolean> {

    public static ValidateResult list() {
        return new ValidateResult();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            Thread.sleep(90000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Persons> personList = SqlRdsExecutor.QueryRds();
        Persons person = new Persons(ID_USER, NAME_USER, GENDER_USER);
        return personList.get(0).getId().equals(person.getId());
    }


}
