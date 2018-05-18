package work;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by zhangdong on 2018/5/15.
 */
public class WorkTester {
    public static void main(String[] args) {
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
