package com.example.mysocket.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "eventType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(
                value = User.class,
                name = "user"
        ),
        @JsonSubTypes.Type(
                value = Customer.class,
                name = "customer"
        )
})
public abstract class AbstractMessage implements Serializable {
    public AbstractMessage() {
    }
}
