package com.boitdroid.ExpressAPI.controllers;

import com.boitdroid.ExpressAPI.payloads.response.AccessTokenResponse;
import com.boitdroid.ExpressAPI.services.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpressController {

    @Autowired
    ExpressService expressService;

    @GetMapping("/accessToken")
    public ResponseEntity<AccessTokenResponse> authGetToken(){
       return ResponseEntity.ok(expressService.authGetToken());
    }
}
