package com.heshen.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 92968
 */
public class ShaUtils {
    public String SHA(final String strText){
        String strResult=null;
        if (strText==null||strText.length()<1){
            return null;
        }
        try {
            MessageDigest messageDigest =MessageDigest.getInstance("SHA-256");
            messageDigest.update(strText.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer strHasString = new StringBuffer();
            for (int i=0;i<digest.length;i++){
                String hex =Integer.toHexString(0xff & digest[i]);
                if (hex.length()==1){
                    strHasString.append('0');
                }
                strHasString.append(hex);
            }
            strResult=strHasString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return strResult;
    }
}
