package com.javacodegeeks.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SysOutContextHandler implements RequestHandler<String,String> {

    @Override
    public String handleRequest(String input, Context context) {
        System.out.println("awsRequestId=" + context.getAwsRequestId());
        System.out.println("functionName=" + context.getFunctionName());
        System.out.println("functionVersion=" + context.getFunctionVersion());
        System.out.println("memoryLimitInMB=" + context.getMemoryLimitInMB());
        System.out.println("remainingTimeInMillis=" + context.getRemainingTimeInMillis());
        return "OK";
    }
}
