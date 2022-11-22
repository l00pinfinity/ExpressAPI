package com.boitdroid.ExpressAPI.payloads.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FailedErrorResponse {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("errorCode")
    private String errorCode;

    @JsonProperty("errorMessage")
    private String errorMessage;
}
