package com.boitdroid.ExpressAPI.payloads.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExpressQuerySuccessfulResponse {

    @JsonProperty("ResponseCode")
    private String ResponseCode;

    @JsonProperty("ResponseDescription")
    private String ResponseDescription;

    @JsonProperty("MerchantRequestID")
    private String MerchantRequestID;

    @JsonProperty("CheckoutRequestID")
    private String CheckoutRequestID;

    @JsonProperty("ResultCode")
    private String ResultCode;

    @JsonProperty("ResultDesc")
    private String ResultDesc;
}
