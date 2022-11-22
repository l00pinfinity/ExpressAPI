package com.boitdroid.ExpressAPI.payloads.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InternalExpressRequest {

    @JsonProperty("Amount")
    private int amount;

    @JsonProperty("PhoneNumber")
    private long phoneNumber;
}
