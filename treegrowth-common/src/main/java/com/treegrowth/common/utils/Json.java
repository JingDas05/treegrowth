package com.treegrowth.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.PropertyNamingStrategy.LOWER_CAMEL_CASE;

public class Json {
    private static final Logger logger = LoggerFactory.getLogger(Json.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(NON_NULL);
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setPropertyNamingStrategy(LOWER_CAMEL_CASE);
    }

    public static <T> T readValue(String content, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(content, typeReference);
        } catch (IOException e) {
            logger.warn(e.getLocalizedMessage());
            return null;
        }
    }

    public static <T> String writeValueAsString(Object object, TypeReference<T> typeReference) {

        if (object != null) {
            try {
                return objectMapper.writerFor(typeReference).writeValueAsString(object);
            } catch (JsonProcessingException e) {
                logger.warn(e.getLocalizedMessage());
                return null;
            }
        }
        return null;
    }

    public static String readNode(String content, String fieldName) {
        try {
            JsonNode jsonNode = objectMapper.readTree(content).get(fieldName);
            return jsonNode == null ? null : jsonNode.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
