//package co.com.bancolombia.rds.glue.utils.aws;
//
//import software.amazon.awssdk.services.rdsdata.RdsDataClient;
//import software.amazon.awssdk.services.rdsdata.model.*;
//
//public class RdsExecutor {
//
//    private static RdsDataClient rdsDataClient = AwsRdsClient.getRdsClient();
//
//    public static void querySdkRds() {
//        try {
//            // Configurar los parámetros de conexión
//            String databaseName = "db-sdk-glue";
//            String clusterArn = "arn:aws:rds:us-east-2:139411963355:cluster:db-cluster-aurora";
//            String secretArn = "arn:aws:secretsmanager:us-east-2:139411963355:secret:aurora-serverless-pXqwkk";
//
//            // Configurar la consulta SQL
//            String sqlStatement = "SELECT * FROM Persons";
//
//            // Configurar los parámetros de ejecución
//            ExecuteStatementRequest executeStatementRequest = ExecuteStatementRequest
//                    .builder()
//                    .resourceArn(clusterArn)
//                    .secretArn(secretArn)
//                    .database(databaseName)
//                    .sql(sqlStatement)
//                    .continueAfterTimeout(true)
//                    .build();
//
//            // Ejecutar la consulta
//            ExecuteStatementResponse executeStatementResponse = rdsDataClient.executeStatement(executeStatementRequest);
////
//            System.out.println(executeStatementResponse);
////            // Procesar los resultados
////            for (Field field : executeStatementResponse.columnMetadata()) {
////                System.out.print(field.name() + "\t");
////            }
////            System.out.println();
////
////            for (Row row : executeStatementResponse.records()) {
////                for (Value value : row.data()) {
////                    System.out.print(value.stringValue() + "\t");
////                }
////                System.out.println();
////            }
//
//            // Cerrar el cliente de RDS Data
//            rdsDataClient.close();
//
//        } catch (BadRequestException | StatementTimeoutException | InternalServerErrorException | ForbiddenException
//                 | ServiceUnavailableErrorException dataException) {
//            System.out.println("Execute statement failed: Error Message: {}, Cause: {}" +
//                    dataException.getMessage() + dataException.getCause());
//        }
//    }
//}
