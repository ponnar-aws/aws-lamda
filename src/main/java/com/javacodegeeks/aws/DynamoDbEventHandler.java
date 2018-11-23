package com.javacodegeeks.aws;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.StreamRecord;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class DynamoDbEventHandler implements RequestHandler<DynamodbEvent, String> {
    private static final Logger LOGGER = LogManager.getLogger(DynamoDbEventHandler.class);

    @Override
    public String handleRequest(DynamodbEvent dynamodbEvent, Context context) {
        List<DynamodbEvent.DynamodbStreamRecord> records = dynamodbEvent.getRecords();
        if (records != null) {
            for (DynamodbEvent.DynamodbStreamRecord record : records) {
                StringBuilder sb = new StringBuilder();
                sb.append("eventName=").append(record.getEventName());
                StreamRecord dynamodb = record.getDynamodb();
                if (dynamodb != null) {
                    sb.append(";keys=");
                    appendMap(sb, dynamodb.getKeys());
                    sb.append(";oldImage=");
                    appendMap(sb, dynamodb.getOldImage());
                    sb.append(";newImage=");
                    appendMap(sb, dynamodb.getNewImage());
                }
                LOGGER.info("Record: " + sb.toString());
            }
        }
        return "OK";
    }

    private void appendMap(StringBuilder sb, Map<String, AttributeValue> map) {
        if (map != null) {
            int count = 0;
            for (Map.Entry<String, AttributeValue> entry : map.entrySet()) {
                if (count > 0) {
                    sb.append(",");
                }
                sb.append(entry.getKey()).append("/").append(entry.getValue());
                count++;
            }
        }
    }
}
