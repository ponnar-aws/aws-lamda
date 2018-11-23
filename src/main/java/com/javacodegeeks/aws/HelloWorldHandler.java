package com.javacodegeeks.aws;

import com.amazonaws.services.lambda.runtime.Context;

public class HelloWorldHandler {

    public String handleRequest(String input, Context context) {
        return "My first request handler: " + input;
    }
}
