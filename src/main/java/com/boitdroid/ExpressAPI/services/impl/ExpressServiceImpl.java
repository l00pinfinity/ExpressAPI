package com.boitdroid.ExpressAPI.services.impl;

import com.boitdroid.ExpressAPI.data.Express;
import com.boitdroid.ExpressAPI.payloads.request.ExpressRequest;
import com.boitdroid.ExpressAPI.payloads.request.ExpressStatusRequest;
import com.boitdroid.ExpressAPI.payloads.response.AccessTokenResponse;
import com.boitdroid.ExpressAPI.payloads.response.ExpressResponse;
import com.boitdroid.ExpressAPI.payloads.response.ExpressStatusResponse;
import com.boitdroid.ExpressAPI.services.ExpressService;
import com.boitdroid.ExpressAPI.utils.Constants;
import com.boitdroid.ExpressAPI.utils.HelperUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public AccessTokenResponse authGetToken() {

        //Using Basic Auth
        Request request = new Request.Builder()
                .addHeader("Authorization", "Basic Q2FzVXBSdjd6UzdIUGJCR2VDM0FKSlM3bjRVckE3Wkc6emY4YmdzcWg4enVSa3F5RQ==")
                .url(Constants.ACCESSTOKEN_URL)
                .build();

        try{
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;

            //Decode response body
            return objectMapper.readValue(response.body().string(),AccessTokenResponse.class);
        }catch (IOException e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ExpressResponse stkPush(ExpressRequest expressRequest) {
        return null;
    }

    @Override
    public ExpressStatusResponse stkPushStatus(ExpressStatusRequest expressStatusRequest) {
        return null;
    }
}
