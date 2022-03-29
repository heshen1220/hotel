package com.heshen.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaUtils {
    public String SHA(final String strText){
        //返回值
        String strResult=null;
        //检查是否为有效字符
        if (strText==null||strText.length()<1){
            return null;
        }
        try {
            //创建加密对象，并传入密码类型
            MessageDigest messageDigest =MessageDigest.getInstance("SHA-256");
            //传入加密字符
            messageDigest.update(strText.getBytes());
            //得到byte类型结果
            byte[] digest = messageDigest.digest();
            StringBuffer strHasString = new StringBuffer();
            //遍历拼接
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
