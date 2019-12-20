package edu.swjtuhc.utils;

import java.util.Random;
import java.util.UUID;

public final class UUIDUtils {
	public UUIDUtils() {

    }

    /**
     * 自动生成32位的UUID，对应数据库会员表的主键，进行插入用
     *
     * @return
     */
    public static String getPkUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 自动生成11位的UID，对应会员特殊标识
     *
     * @return
     */
    public static String getUserUUID() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 11; i++) {
            //首字母不能为0
            result += (random.nextInt(9) + 1);
        }
        return result;
    }

}
