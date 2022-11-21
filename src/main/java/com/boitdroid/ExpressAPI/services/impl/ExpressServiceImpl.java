package com.boitdroid.ExpressAPI.services.impl;

import com.boitdroid.ExpressAPI.payloads.response.AccessTokenFailedResponse;
import com.boitdroid.ExpressAPI.payloads.response.AccessTokenSuccessfulResponse;
import com.boitdroid.ExpressAPI.services.ExpressService;
import com.boitdroid.ExpressAPI.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Object authGetToken() throws IOException {

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
}
