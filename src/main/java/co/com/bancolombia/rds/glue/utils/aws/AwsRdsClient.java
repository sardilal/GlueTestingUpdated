//package co.com.bancolombia.rds.glue.utils.aws;
//
//import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.rdsdata.RdsDataClient;
//import software.amazon.awssdk.services.rdsdata.model.RdsDataException;
//
//public class AwsRdsClient {
//    public static RdsDataClient getRdsClient() {
//        try {
//            RdsDataClient rdsDataClient = RdsDataClient.builder()
//                    .region(Region.US_EAST_2)
//                    .credentialsProvider(DefaultCredentialsProvider.create())
//                    .build();
//            System.out.println(rdsDataClient);
//            return rdsDataClient;
//        } catch (RdsDataException e) {
//            throw e;
//        }
//    }
//}
