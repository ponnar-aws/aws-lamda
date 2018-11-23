package com.javacodegeeks.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaLoggerContextHandler implements RequestHandler<String,String> {

    @Override
    public String handleRequest(String input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("awsRequestId=" + context.getAwsRequestId());
        logger.log("functionName=" + context.getFunctionName());
        logger.log("functionVersion=" + context.getFunctionVersion());
        logger.log("memoryLimitInMB=" + context.getMemoryLimitInMB());
        logger.log("remainingTimeInMillis=" + context.getRemainingTimeInMillis());
        return "OK";
    }
}
