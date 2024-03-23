package org.training.utils;

import java.util.Base64;

public class StringDecoder {

    private static String decodedString;

    public static String decodeBase64(String encodedString) {

        try {
            decodedString = new String(Base64.getDecoder().decode(encodedString));
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return decodedString;
    }

    public static String encodeBase64(String value) {

        return new String(Base64.getEncoder().encode(value.getBytes()));
    }
}
