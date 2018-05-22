package work.security;

/**
 * MD5工具类，加盐
 * Created by zhangdong on 2018/5/21.
 */

import java.util.Random;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class MD5Util {

//    /**
//     * 普通MD5
//     * @param src
//     * @return
//     */
//    public static String MD5(String src) {
//        MessageDigest md5 = null;
//        try {
//            md5 = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            return "check jdk";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//        char[] charArray = src.toCharArray();
//        byte[] byteArray = new byte[charArray.length];
//
//        for (int i = 0; i < charArray.length; i++)
//            byteArray[i] = (byte) charArray[i];
//        byte[] md5Bytes = md5.digest(byteArray);
//        StringBuffer hexValue = new StringBuffer();
//        for (int i = 0; i < md5Bytes.length; i++) {
//            int val = ((int) md5Bytes[i]) & 0xff;
//            if (val < 16)
//                hexValue.append("0");
//            hexValue.append(Integer.toHexString(val));
//        }
//        return hexValue.toString();
//
//    }

    /**
     * MD5 加 key 密钥
     * @param src
     * @return
     */
    public static String md5WithKey(String src,String key) {
        String src_key=src+key;
//        DigestUtils.md5Hex(src+key);
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        char[] charArray = src_key.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加盐MD5
     * @author daniel
     * @time 2016-6-11 下午8:45:04
     * @param src
     * @return
     */
    public static String generate(String src,String salt) {
        src = md5Hex(src + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = src.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = src.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 校验加盐后是否和原文一致
     * @author daniel
     * @time 2016-6-11 下午8:45:39
     * @param src
     * @param ciphertext
     * @return
     */
    public static boolean verify(String src, String ciphertext) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = ciphertext.charAt(i);
            cs1[i / 3 * 2 + 1] = ciphertext.charAt(i + 2);
            cs2[i / 3] = ciphertext.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(src + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }




}
