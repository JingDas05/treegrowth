package com.treegrowth.model.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.treegrowth.model.security.Authority;

import java.util.EnumSet;

public class UserAuthorityConverter extends JsonTypeReferenceConverter<EnumSet<Authority>>{

    private TypeReference<EnumSet<Authority>> userConfirmStatuses;

    {
        userConfirmStatuses = new TypeReference<EnumSet<Authority>>() {};
    }

    @Override
    protected TypeReference<EnumSet<Authority>> typeReference() {
        return userConfirmStatuses;
    }
}
