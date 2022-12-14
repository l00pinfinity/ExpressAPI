package com.boitdroid.ExpressAPI.services;

import com.boitdroid.ExpressAPI.payloads.request.ExpressQueryRequest;
import com.boitdroid.ExpressAPI.payloads.request.InternalExpressRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ExpressService {

    //AuthToken
    Object authGetToken() throws IOException;
    //STK Push
    Object stkPush(InternalExpressRequest internalExpressRequest) throws IOException;

    //ExpressStatusQuery
    Object stkPushQuery(ExpressQueryRequest expressQueryRequest) throws IOException;
}
