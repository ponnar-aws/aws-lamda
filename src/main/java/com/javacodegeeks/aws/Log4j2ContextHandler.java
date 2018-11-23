package com.javacodegeeks.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2ContextHandler implements RequestHandler<String,String> {
    private static final Logger LOGGER = LogManager.getLogger(Log4j2ContextHandler.class);

    @Override
    public String handleRequest(String input, Context context) {
        LOGGER.info("awsRequestId=" + context.getAwsRequestId());
        LOGGER.info("functionName=" + context.getFunctionName());
        LOGGER.info("functionVersion=" + context.getFunctionVersion());
        LOGGER.info("memoryLimitInMB=" + context.getMemoryLimitInMB());
        LOGGER.info("remainingTimeInMillis=" + context.getRemainingTimeInMillis());
        System.out.println("awsRequestId=" + context.getAwsRequestId());
        System.out.println("functionName=" + context.getFunctionName());
        System.out.println("functionVersion=" + context.getFunctionVersion());
        System.out.println("memoryLimitInMB=" + context.getMemoryLimitInMB());
        System.out.println("remainingTimeInMillis=" + context.getRemainingTimeInMillis());
        return "OK  -- "+context.getFunctionName();
    }
}
