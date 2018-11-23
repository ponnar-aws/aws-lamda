package com.javacodegeeks.aws;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class ContextHandler implements RequestHandler<String,String> {

    @Override
    public String handleRequest(String input, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("awsRequestId=").append(context.getAwsRequestId()).append("\n");
        sb.append("functionName=").append(context.getFunctionName()).append("\n");
        sb.append("functionVersion=").append(context.getFunctionVersion()).append("\n");
        sb.append("memoryLimitInMB=").append(context.getMemoryLimitInMB()).append("\n");
        sb.append("remainingTimeInMillis=").append(context.getRemainingTimeInMillis()).append("\n");

        ClientContext clientContext = context.getClientContext();
        if (clientContext != null) {
            Map<String, String> environment = clientContext.getEnvironment();
            for (Map.Entry<String, String> entry : environment.entrySet()) {
                sb.append("environment: ").append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
            }
        }
        return sb.toString();
    }
}
