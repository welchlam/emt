package com.welch.emt.util;

import org.junit.Test;

/**
 * Created by Administrator on 2017-6-4.
 */
public class EncryptorTest {
    @Test
    public void testEncrypt(){
        String key = "EMT";
        String password = "root";
        System.out.println(Encryptor.encrypt(key, password));
    }

    @Test
    public void testDecrypt(){
        String key = "EMT";
        String password = "HsFYivZxeyKc9GB9CLpAuA==";
        System.out.println(Encryptor.decrypt(key, password));
    }
}
