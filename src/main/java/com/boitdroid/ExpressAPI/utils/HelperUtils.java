package com.boitdroid.ExpressAPI.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class HelperUtils {

    //Generate Random Transaction Number
    public static String generateRandomTransactionNumber(){
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
        StringBuilder stringBuilder = new StringBuilder();

        Random random = new Random();

        for(int i = 0; i < 12; i++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    //Generate express request password
    public static String expressPassword(int businessShortCode, String expressPasskey, String timestamp) {
        String fullString = businessShortCode + expressPasskey + timestamp;
        return Base64.getEncoder().encodeToString(fullString.getBytes(StandardCharsets.UTF_8));
    }
}
