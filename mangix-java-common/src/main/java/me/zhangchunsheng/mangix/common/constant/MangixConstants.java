package me.zhangchunsheng.mangix.common.constant;

/**
 * <pre>
 * JumpServer常量类
 * Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class MangixConstants {

    /**
     * 结果代码.
     */
    public static class ResultCode {
        /**
         * 成功.
         */
        public static final String SUCCESS = "200";

        /**
         * 失败.
         */
        public static final String FAIL = "0";
    }

    public static class Url {
        public static final String LOGIN_URL = "/api/v1/authentication/sso/login-url";
    }
}
