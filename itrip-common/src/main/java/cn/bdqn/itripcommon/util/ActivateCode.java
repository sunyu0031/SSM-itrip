package cn.bdqn.itripcommon.util;

import java.util.Random;

public class ActivateCode {

    //生成8位数的 字母 大小随机 当做授权码
    public static String getActivateCode() {
        Random r = new Random();
        String code = "";
        for (int i = 0; i < 8; ++i) {
            int temp = r.nextInt(52);
            char x = (char) (temp < 26 ? temp + 97 : (temp % 26) + 65);
            code += x;
        }
        return code;
    }
}
