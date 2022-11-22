package com.boitdroid.ExpressAPI.utils;

public class Constants {

    //Endpoints
    public static final String ACCESSTOKEN_URL = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
    public static final String EXPRESS_URL = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
    public static final String EXPRESSSTATUS_URL = "https://sandbox.safaricom.co.ke/mpesa/stkpushquery/v1/query";
    public static final String CALLBACK_URL = "https://webhook.site/83a48a6d-f354-4954-a46b-2ed47335adba";
    public static final int BUSINESS_SHORTCODE = 174379;
    public static final String TRANSACTION_TYPE1 = "CustomerPayBillOnline";
    public static final String TRANSACTION_TYPE2 = "CustomerBuyGoodsOnline";
}
