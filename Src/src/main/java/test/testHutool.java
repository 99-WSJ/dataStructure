package test;

import cn.hutool.bloomfilter.BloomFilterUtil;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.util.List;

/**
 * @author wsj
 * @description
 * @date 2024年08月03日 13:49
 */
public class testHutool {
    public static void main(String[] args) {
        String jsonStr = JSONUtil.toJsonStr(new UserInfo());
        System.out.println(jsonStr);

        /**
         * 模拟HTTP请求
         * JSONUtil 序列化
         * BeanUtil：Map与javaBean的转换
         * CaptchaUtil 生成图形验证码
         * UserAgentUtil 访问设备
         *     对称加密（symmetric）：例如：AES、DES等
         *     非对称加密（asymmetric）：例如：RSA、DSA等
         *     摘要加密（digest）：例如：MD5、SHA-1、SHA-256、HMAC等
         */

    }
}



@Data
class UserInfo{
    private int age;
    private String name;
    private List<String> hobbies;
}
