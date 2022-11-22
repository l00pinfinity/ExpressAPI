package com.boitdroid.ExpressAPI.controllers;

import com.boitdroid.ExpressAPI.payloads.request.ExpressQueryRequest;
import com.boitdroid.ExpressAPI.payloads.request.ExternalExpressRequest;
import com.boitdroid.ExpressAPI.payloads.request.InternalExpressRequest;
import com.boitdroid.ExpressAPI.services.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExpressController {

    @Autowired
    ExpressService expressService;

    @GetMapping("/accessToken")
    public ResponseEntity<?> getAuthToken() throws IOException {
        return ResponseEntity.ok(expressService.authGetToken());
    }

    @PostMapping("/stkPush")
    public ResponseEntity<?> initiateSTKPush(@RequestBody InternalExpressRequest internalExpressRequest) throws IOException {
        return ResponseEntity.ok(expressService.stkPush(internalExpressRequest));
    }

    @PostMapping("/stkPush/status")
    public ResponseEntity<?> queryStatus(@RequestBody ExpressQueryRequest expressQueryRequest) throws IOException{
        return ResponseEntity.ok(expressService.stkPushQuery(expressQueryRequest));
    }
}
