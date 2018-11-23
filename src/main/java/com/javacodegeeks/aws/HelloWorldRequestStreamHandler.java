package com.javacodegeeks.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class HelloWorldRequestStreamHandler implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream,
                              Context context) throws IOException {
        Charset encoding = Charset.forName("UTF-8");
        String input = IOUtils.toString(inputStream, encoding);
        String output = "My first request handler: " + input;
        IOUtils.write(output, outputStream, encoding);
    }
}
