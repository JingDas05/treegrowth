package com.treegrowth.model.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.treegrowth.common.utils.Json;

import javax.persistence.AttributeConverter;

import static com.treegrowth.common.utils.Json.writeValueAsString;

public abstract class JsonTypeReferenceConverter<T> implements AttributeConverter<T, String> {


    @Override
    public String convertToDatabaseColumn(T value) {

        return writeValueAsString(value, typeReference());
    }

    @Override
    public T convertToEntityAttribute(String content) {

        return content == null ? null : Json.readValue(content, typeReference());
    }

    abstract protected TypeReference<T> typeReference();
}
