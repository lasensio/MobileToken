package com.example.asensio.mobiletoken;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by asensio on 18/09/16.
 */
public class GenerateToken {

    public String generateNonce() {
        String token;
        token = null;
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

            byte[] bytes = new byte[1024/8];
            sr.nextBytes(bytes);

            int seedByteCount = 10;
            byte[] seed = sr.generateSeed(seedByteCount);

            sr.setSeed(seed);

            int value = ((0xFF & seed[0]) << 24) | ((0xFF & seed[1]) << 16) | ((0xFF & seed[2]) << 8) | (0xFF & seed[3]);

            value = Math.abs(value);
            token = Integer.toString(value);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return token;
    }
}
