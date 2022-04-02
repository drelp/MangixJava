package me.zhangchunsheng.mangix.common.config;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;

/**
 * JumpServer配置
 *
 * @author Chunsheng Zhang (https://github.com/zhangchunsheng)
 */
@Data
public class MangixConfig {
    /**
     * JumpServer接口请求地址域名部分.
     */
    private String baseUrl;

    /**
     * http请求连接超时时间.
     */
    private int httpConnectionTimeout = 5000;

    /**
     * http请求数据读取等待时间.
     */
    private int httpTimeout = 10000;

    /**
     * JumpServer privateToken.
     */
    private String privateToken;

    /**
     * 是否将接口请求日志信息保存到threadLocal中.
     * 默认不保存
     */
    private boolean ifSaveApiData = false;

    private String httpProxyHost;
    private Integer httpProxyPort;
    private String httpProxyUsername;
    private String httpProxyPassword;

    /**
     * 返回所设置的JumpServer接口请求地址域名.
     *
     * @return JumpServer接口请求地址域名
     */
    public String getBaseUrl() throws InvalidParameterException {
        if (StringUtils.isEmpty(this.baseUrl)) {
            throw new InvalidParameterException();
        }

        return this.baseUrl;
    }
}
