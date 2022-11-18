package com.boitdroid.ExpressAPI.payloads.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExpressRequest {

    @JsonProperty("BusinessShortCode")
    private int businessShortCode;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Timestamp")
    private String timestamp;

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("Amount")
    private int amount;

    @JsonProperty("PartyA")
    private int partyA;

    @JsonProperty("PartyB")
    private int partyB;

    @JsonProperty("PhoneNumber")
    private int phoneNumber;

    @JsonProperty("CallBackURL")
    private String callBackURL;

    @JsonProperty("AccountReference")
    private String accountReference;

    @JsonProperty("TransactionDesc")
    private String transactionDesc;
}
