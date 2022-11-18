package com.boitdroid.ExpressAPI.services;

import com.boitdroid.ExpressAPI.payloads.request.ExpressRequest;
import com.boitdroid.ExpressAPI.payloads.request.ExpressStatusRequest;
import com.boitdroid.ExpressAPI.payloads.response.AccessTokenResponse;
import com.boitdroid.ExpressAPI.payloads.response.ExpressResponse;
import com.boitdroid.ExpressAPI.payloads.response.ExpressStatusResponse;
import org.springframework.stereotype.Service;

@Service
public interface ExpressService {

    AccessTokenResponse authGetToken();
    ExpressResponse stkPush(ExpressRequest expressRequest);
    ExpressStatusResponse stkPushStatus(ExpressStatusRequest expressStatusRequest);
}
