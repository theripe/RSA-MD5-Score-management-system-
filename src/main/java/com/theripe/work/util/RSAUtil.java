package com.theripe.work.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

import java.security.interfaces.RSAPublicKey;

/**
 * @Author TheRipe
 * @create 2021/7/13 12:36
 */

public class RSAUtil {
    private static final KeyPair keyPair = initKey();
    private static KeyPair initKey() {
        try {
            Provider provider =new org.bouncycastle.jce.provider.BouncyCastleProvider();
            Security.addProvider(provider);
            SecureRandom random = new SecureRandom();
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", provider);
            generator.initialize(1024,random);
            return generator.generateKeyPair();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String generateBase64PublicKey() {
        PublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        return new String(Base64.encodeBase64(publicKey.getEncoded()));
    }
    public static String decryptBase64(String string) {
        return new String(decrypt(Base64.decodeBase64(string.getBytes())));
    }

    private static byte[] decrypt(byte[] byteArray) {
        try {
            Provider provider = new org.bouncycastle.jce.provider.BouncyCastleProvider();
            Security.addProvider(provider);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", provider);
            PrivateKey privateKey = keyPair.getPrivate();
            System.out.println( new String(Base64.encodeBase64(privateKey.getEncoded())));
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] plainText = cipher.doFinal(byteArray);
            return plainText;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {


    }
}
