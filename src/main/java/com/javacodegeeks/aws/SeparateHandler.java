package com.javacodegeeks.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SeparateHandler implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
        return echoString(input, context.getAwsRequestId());
    }

    private String echoString(String input, String awsRequestId) {
        return input + " (AWS-Request-ID: " + awsRequestId + ")";
    }
}
