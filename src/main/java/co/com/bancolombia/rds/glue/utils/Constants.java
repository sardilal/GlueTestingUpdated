package co.com.bancolombia.rds.glue.utils;

public class Constants {
    public static final String ID_USER = "0005af3a-9471-4d1f-9299-737fff4b9b46";
    public static final String NAME_USER = "Mac Collins";
    public static final String GENDER_USER = "male";
    public static final String JOB_STATE = "SUCCEEDED";
    public static final String JOB_STATE_STOP = "STOPPED";
    public static final String JOB_STATE_FAILED = "FAILED";
    public static final String JOB_STATE_TIMEOUT = "TIMEOUT";
    public static final String URL_CONNECTION_DATABASE = "jdbc:mysql://db-sdk-glue.c3zxu2fzxm0o.us-east-2.rds.amazonaws.com:3306/db-sdk-glue";
    public static final String USER_DATABASE = "admin";
    public static final String PASSWORD_DATABASE = "Nicolas99r-";
    public static final String QUERY = "(SELECT * FROM Persons  ORDER BY tag ASC LIMIT 5) UNION (SELECT * FROM (SELECT * FROM Persons  ORDER BY tag  DESC LIMIT 5) sub ORDER BY id ASC)";








}
