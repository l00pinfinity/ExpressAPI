package com.boitdroid.ExpressAPI.data;

import lombok.Data;

@Data
public class Express {

    private int businessShortCode;
    private String password;
    private String timestamp;
    private String transactionType;
    private int amount;
    private int partyA;
    private int partyB;
    private int phoneNumber;
    private String callBackURL;
    private String accountReference;
    private String transactionDesc;
}
