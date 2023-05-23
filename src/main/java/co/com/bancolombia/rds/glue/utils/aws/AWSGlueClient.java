package co.com.bancolombia.rds.glue.utils.aws;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.glue.GlueClient;
import software.amazon.awssdk.services.glue.model.GlueException;

public class AWSGlueClient {
    public static GlueClient getGlueClient() {
        try {
            GlueClient glueClient = GlueClient.builder()
                    .region(Region.US_EAST_2)
                    .credentialsProvider(DefaultCredentialsProvider.create())
                    .build();
            return glueClient;
        } catch (GlueException e) {
            throw e;
        }
    }
}
