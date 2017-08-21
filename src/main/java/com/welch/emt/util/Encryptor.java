package com.welch.emt.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * Created by Administrator on 2017-6-4.
 */
public class Encryptor {

    public static String encrypt(String key, String password){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(key);
        return encryptor.encrypt(password);
    }

    public static String decrypt(String key, String password){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(key);
        return encryptor.decrypt(password);
    }

    public static String encrypt(String password){
        String key = System.getProperty("emt.app.key");
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(key);
        return encryptor.encrypt(password);
    }

    public static String decrypt(String password){
        String key = System.getProperty("emt.app.key");
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(key);
        return encryptor.decrypt(password);
    }
}
