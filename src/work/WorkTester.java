package work;

import org.apache.commons.codec.digest.DigestUtils;
import work.security.MD5Util;

/**
 * Created by zhangdong on 2018/5/15.
 */
public class WorkTester {
    public static void main(String[] args) {
        // 原文
        String plaintext = "DingSai";
        //  plaintext = "123456";
        System.out.println("原始：" + plaintext);
//        System.out.println("普通MD5后：" + MD5Util.md5WithKey(plaintext,"key"));

        // 获取加盐后的MD5值
//        String ciphertext = MD5Util.generate(plaintext,"salt");
//        System.out.println("加盐后MD5：" + ciphertext);
//        System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, ciphertext));
        /**
         * 其中某次DingSai字符串的MD5值
         */
        String[] tempSalt = { "c4d980d6905a646d27c0c437b1f046d4207aa2396df6af86", "66db82d9da2e35c95416471a147d12e46925d38e1185c043", "61a718e4c15d914504a41d95230087a51816632183732b5a" };

        for (String temp : tempSalt) {
//            System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, temp));
        }







        String sign= DigestUtils.md5Hex("123"+"mCAEO7bI8nlzskTlX2RNbOZXVIX0VgOm"+"xq_009");
        System.out.println(sign);
        /**
         *   海关，aes加密
         * **/
        String caller=null,appNo=null,privateKey=null,signature;
        StringBuilder signStr = new StringBuilder();
        signStr.append(caller)
                .append("_")
                .append(appNo)
                .append("_")
                .append(privateKey);

        signature= DigestUtils.md5Hex(signStr.toString());
    }
}
