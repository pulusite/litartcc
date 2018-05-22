package work.security;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangdong on 2018/5/9.
 */
public class MD5_ {
    /**
     * MD5生成签名字符串
     *
     * @param map
     *            需签名参数
     * @param key
     *            MD5key
     * @return
     */
    public static String MD5sign(Map<String, Object> map, String key) {
        String genSign = "";
        try {

            String[] signFields = new String[5];
            signFields[0] = "name";
            signFields[1] = "age";
            signFields[2] = "sex";
            signFields[3] = "school";
            signFields[4] = "address";
            JSONObject param = (JSONObject) JSONObject.toJSON(map);
            // 生成签名原文
            String signSrc = orgSignSrc(signFields, param);
            // MD5的方式签名
            signSrc += "&KEY=" + key;
//            genSign = MD5Encrypt.getMessageDigest(signSrc);
            genSign = DigestUtils.md5Hex(signSrc);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return genSign;
    }

    /**
     * 构建签名原文
     *
     * @param signFields 参数列表
     * @param param 参数与值的jsonbject
     * @return
     */
    private static String orgSignSrc(String[] signFields, JSONObject param) {
        if (signFields != null) {
            Arrays.sort(signFields); // 对key按照 字典顺序排序
        }

        StringBuffer signSrc = new StringBuffer("");
        int i = 0;
        for (String field : signFields) {
            signSrc.append(field);
            signSrc.append("=");
            signSrc.append((param.getString(field)==null || param.getString(field).length()==0) ? ""
                    : param.getString(field));
            // 最后一个元素后面不加&
            if (i < (signFields.length - 1)) {
                signSrc.append("&");
            }
            i++;
        }
        return signSrc.toString();
    }

    /**
     * MD5验证签名
     * @param map
     * @param key
     * @param sign
     * @return
     */
    public static void vlidateMD5sign(Map<String ,Object> map,String key,String sign) {
        String vsign=MD5sign(map, key);
        System.out.println("MD5验证签名生成的签名："+vsign);
        System.out.println("MD5验证签名生成的签名与原签名是否一致：sign=vsign true?false:"+(vsign.equals(sign)));
    }

    public static void main(String[] args) {

        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("name", "小明");
        map.put("age", 12);
        map.put("sex", "男");
        map.put("school", "xxx中学");
        map.put("address", "xxx小区");
        /***MD5签名与验签**/
        String key="123456ADSEF";
        String sign= MD5sign(map,key);
        System.out.println("生成的MD5签名："+sign);
        vlidateMD5sign(map, key, sign) ;


    }
}
