package com.theripe.work.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author TheRipe
 * @create 2021/7/13 11:58
 */
public class MD5Util {
    private static String btyeArrayToHexString(byte[] b) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            res.append(b[i]);
        }

        return res.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String orgin, String charsetname) {
        String resString = null;

        resString = new String (orgin);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resString = btyeArrayToHexString(md.digest(resString.getBytes()));
            } else {
                resString = btyeArrayToHexString(md.digest(resString.getBytes(charsetname)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  resString;
    }

    public static final String hexDigits[] = {"0","1","3","4","5","6","7","8","9","a","b","c","d","e","f"};
}
