package work.security;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.json.GsonJsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangdong on 2018/6/11.
 */
public class Main {
    public static void main(String[] args) {
        String encryptKey="123456789";
        String md5salt="WN(dQxgKWV";
        Map<String,String> paramMap=new HashMap<String, String>();
        paramMap.put("orderNo","");
        paramMap.put("psusercode","");
        Gson gson=new Gson();
        String param= gson.toJson(paramMap);
        byte[] databytes= DESUtil.encrypt(param.getBytes(),encryptKey);
        String data= Base64Util.encode(databytes);
        String md5= MD5Util.MD5(data+md5salt);
        Map<String,String> httpParamMap=new HashMap<String, String>();
        httpParamMap.put("data",data);
        httpParamMap.put("md5",md5);
        String httpparam= gson.toJson(httpParamMap);
    }
}
