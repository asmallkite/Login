package com.example.a10648.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 10648 on 2016/5/28 0028.
 */
public class Encrypt {
    public static String md5(String str){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return  "";
        }
        char [] charArray = str.toCharArray();
        byte [] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++){
            byteArray[i] = (byte)charArray[i];
        }
        byte [] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
