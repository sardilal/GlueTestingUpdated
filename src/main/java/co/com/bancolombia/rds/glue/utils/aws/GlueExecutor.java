package co.com.bancolombia.rds.glue.utils.aws;

import software.amazon.awssdk.services.glue.GlueClient;
import software.amazon.awssdk.services.glue.model.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static co.com.bancolombia.rds.glue.utils.Constants.*;

public class GlueExecutor {
    public static final Logger LOGGER = Logger.getLogger(GlueExecutor.class.getName());

    private static GlueClient glueClient = AWSGlueClient.getGlueClient();

    public static void startCrawler(String crawlerName) {

        LOGGER.info(String.format("----> Starting crawler: [%1$s]", crawlerName));
        try {
            StartCrawlerRequest crawlerRequest = StartCrawlerRequest.builder()
                    .name(crawlerName)
                    .build();
            glueClient.startCrawler(crawlerRequest);
        } catch (GlueException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }

    }

    public static void startJob(String jobName) {
        try {
            StartJobRunRequest runRequest = StartJobRunRequest.builder()
                    .workerType(WorkerType.G_1_X)
                    .numberOfWorkers(10)
                    .jobName(jobName)
                    .build();

            StartJobRunResponse response = glueClient.startJobRun(runRequest);
            System.out.println("The request ID of the job is " + response.responseMetadata().requestId());
        } catch (GlueException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    public static void getJobRuns(String jobName) {
        try {
            GetJobRunsRequest runsRequest = GetJobRunsRequest.builder()
                    .jobName(jobName)
                    .maxResults(1)
                    .build();

            boolean jobDone = false;
            while (!jobDone) {
                GetJobRunsResponse response = glueClient.getJobRuns(runsRequest);
                List<JobRun> jobRuns = response.jobRuns();
                for (JobRun jobRun : jobRuns) {
                    String jobState = jobRun.jobRunState().name();
                    if (jobState.compareTo(JOB_STATE) == 0) {
                        System.out.println(jobName + " has succeeded");
                        jobDone = true;

                    } else if (jobState.compareTo(JOB_STATE_STOP) == 0) {
                        System.out.println("Job run has stopped");
                        jobDone = true;

                    } else if (jobState.compareTo(JOB_STATE_FAILED) == 0) {
                        System.out.println("Job run has failed");
                        jobDone = true;

                    } else if (jobState.compareTo(JOB_STATE_TIMEOUT) == 0) {
                        System.out.println("Job run has timed out");
                        jobDone = true;

                    } else {
                        System.out.println("*** Job run state is " + jobRun.jobRunState().name());
                        System.out.println("Job run Id is " + jobRun.id());
                        System.out.println("The Glue version is " + jobRun.glueVersion());
                    }
                    TimeUnit.SECONDS.sleep(5);
                }
            }
        } catch (GlueException | InterruptedException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
