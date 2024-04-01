package org.training.utils;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptionService {
    private SecretKey secretKey;
    private Cipher cipher;

    public EncryptionService(String key) throws GeneralSecurityException {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        secretKey = new SecretKeySpec(keyBytes, "AES");
        cipher = Cipher.getInstance("AES/GCM/NoPadding");
    }

    public String encrypt(String original) throws GeneralSecurityException {
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(128, iv));
        byte[] encryptedData = cipher.doFinal(original.getBytes());
        var encoder = Base64.getEncoder();
        var encrypt64 = encoder.encode(encryptedData);
        var iv64 = encoder.encode(iv);
        return StringUtils.join(new String(encrypt64), "#", new String(iv64));
    }

    public String decrypt(String cypher) throws GeneralSecurityException {
        var split = cypher.split("#");
        var decoder = Base64.getDecoder();
        var cypherText = decoder.decode(split[0]);
        var iv = decoder.decode(split[1]);
        var paraSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, paraSpec);
        byte[] decryptedData = cipher.doFinal(cypherText);
        return new String(decryptedData);
    }
}
