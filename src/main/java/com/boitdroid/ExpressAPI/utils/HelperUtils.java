package com.boitdroid.ExpressAPI.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

        for(int i = 0; i < 10; i++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    public static String convertToJson(Object object){
        try{
            return new ObjectMapper().writeValueAsString(object);
        }catch (JsonProcessingException e){
            return null;
        }
    }
}
