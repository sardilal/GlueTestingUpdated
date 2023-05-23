package co.com.bancolombia.rds.glue.exceptions;

public class AssertionException extends AssertionError {

    public AssertionException(String mensaje) {
        super(mensaje);
    }

    public AssertionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
