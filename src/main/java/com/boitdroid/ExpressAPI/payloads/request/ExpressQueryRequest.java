package com.boitdroid.ExpressAPI.payloads.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExpressQueryRequest {

    @JsonProperty("BusinessShortCode")
    private int BusinessShortCode;

    @JsonProperty("Password")
    private String Password;

    @JsonProperty("Timestamp")
    private String Timestamp;

    @JsonProperty("CheckoutRequestID")
    private String CheckoutRequestID;
}
