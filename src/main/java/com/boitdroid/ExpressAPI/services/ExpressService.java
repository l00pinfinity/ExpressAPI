package com.boitdroid.ExpressAPI.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ExpressService {

    //AuthToken
    Object authGetToken() throws IOException;
    //STK Push

    //ExpressStatusQuery
}
