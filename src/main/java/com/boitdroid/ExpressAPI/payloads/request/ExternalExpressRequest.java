package com.boitdroid.ExpressAPI.payloads.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExternalExpressRequest {

    @JsonProperty("BusinessShortCode")
    private int BusinessShortCode;

    @JsonProperty("Password")
    private String Password;

    @JsonProperty("Timestamp")
    private String Timestamp;

    @JsonProperty("TransactionType")
    private String TransactionType;

    @JsonProperty("Amount")
    private int Amount;

    @JsonProperty("PartyA")
    private long PartyA;

    @JsonProperty("PartyB")
    private int PartyB;

    @JsonProperty("PhoneNumber")
    private long PhoneNumber;

    @JsonProperty("CallBackURL")
    private String CallBackURL;

    @JsonProperty("AccountReference")
    private String AccountReference;

    @JsonProperty("TransactionDesc")
    private String TransactionDesc;
}
