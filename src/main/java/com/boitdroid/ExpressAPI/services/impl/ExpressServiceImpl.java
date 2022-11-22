package com.boitdroid.ExpressAPI.services.impl;

import com.boitdroid.ExpressAPI.payloads.request.ExpressQueryRequest;
import com.boitdroid.ExpressAPI.payloads.request.ExternalExpressRequest;
import com.boitdroid.ExpressAPI.payloads.request.InternalExpressRequest;
import com.boitdroid.ExpressAPI.payloads.response.*;
import com.boitdroid.ExpressAPI.services.ExpressService;
import com.boitdroid.ExpressAPI.utils.Constants;
import com.boitdroid.ExpressAPI.utils.HelperUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Object authGetToken() {

        try{
            //Using Basic Auth
            Request request = new Request.Builder()
                    .addHeader("Authorization", "Basic Q2FzVXBSdjd6UzdIUGJCR2VDM0FKSlM3bjRVckE3Wkc6emY4YmdzcWg4enVSa3F5RQ==")
                    .url(Constants.ACCESSTOKEN_URL)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;
            if (response.isSuccessful()){
                return objectMapper.readValue(response.body().string(), AccessTokenSuccessfulResponse.class);
            }else {
                return objectMapper.readValue(response.body().string(), AccessTokenFailedResponse.class);
            }
        }catch (IOException e){
            return e.getLocalizedMessage();
        }
    }

    @Override
    public Object stkPush(InternalExpressRequest internalExpressRequest) throws IOException {
        ExternalExpressRequest expressRequest = new ExternalExpressRequest();

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String password = HelperUtils.expressPassword(Constants.BUSINESS_SHORTCODE,"bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919",timeStamp);

        expressRequest.setBusinessShortCode(Constants.BUSINESS_SHORTCODE);
        expressRequest.setPassword(password);
        expressRequest.setTimestamp(timeStamp);
        expressRequest.setTransactionType(Constants.TRANSACTION_TYPE1);
        expressRequest.setAmount(internalExpressRequest.getAmount());
        expressRequest.setPartyA(internalExpressRequest.getPhoneNumber());
        expressRequest.setPartyB(Constants.BUSINESS_SHORTCODE);
        expressRequest.setPhoneNumber(internalExpressRequest.getPhoneNumber());
        expressRequest.setCallBackURL(Constants.CALLBACK_URL);
        expressRequest.setAccountReference(HelperUtils.generateRandomTransactionNumber());
        expressRequest.setTransactionDesc("C2B transaction vial STKPush from " + internalExpressRequest.getPhoneNumber());

        AccessTokenSuccessfulResponse accessTokenSuccessfulResponse = (AccessTokenSuccessfulResponse) authGetToken();
        Gson gson = new Gson();
        RequestBody requestBody = RequestBody.create(MediaType.Companion.get("application/json"),Objects.requireNonNull(gson.toJson(expressRequest)));

        Request request = new Request.Builder()
                .url(Constants.EXPRESS_URL)
                .post(requestBody)
                .addHeader("Authorization","Bearer " + accessTokenSuccessfulResponse.getAccessToken())
                .build();

        Response response = okHttpClient.newCall(request).execute();
        assert response.body() != null;
        if (response.isSuccessful()){
            return objectMapper.readValue(response.body().string(), STKPushSuccessfulResponse.class);
        }else{
            return objectMapper.readValue(response.body().string(), STKPushFailedResponse.class);
        }
    }

    @Override
    public Object stkPushQuery(ExpressQueryRequest expressQueryRequest) throws IOException {
        ExpressQueryRequest queryRequest = new ExpressQueryRequest();

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String password = HelperUtils.expressPassword(Constants.BUSINESS_SHORTCODE,"bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919",timeStamp);

        queryRequest.setBusinessShortCode(Constants.BUSINESS_SHORTCODE);
        queryRequest.setPassword(password);
        queryRequest.setTimestamp(timeStamp);
        queryRequest.setCheckoutRequestID(expressQueryRequest.getCheckoutRequestID());

        AccessTokenSuccessfulResponse accessTokenSuccessfulResponse = (AccessTokenSuccessfulResponse) authGetToken();
        Gson gson = new Gson();
        RequestBody requestBody = RequestBody.create(MediaType.Companion.get("application/json"),Objects.requireNonNull(gson.toJson(queryRequest)));

        Request request = new Request.Builder()
                .url(Constants.EXPRESSSTATUS_URL)
                .post(requestBody)
                .addHeader("Authorization","Bearer " + accessTokenSuccessfulResponse.getAccessToken())
                .build();

        Response response = okHttpClient.newCall(request).execute();
        assert response.body() != null;
        if (response.isSuccessful()){
            return objectMapper.readValue(response.body().string(), ExpressQuerySuccessfulResponse.class);
        }else {
            return objectMapper.readValue(response.body().string(), ExpressQueryFailedResponse.class);
        }
    }
}
