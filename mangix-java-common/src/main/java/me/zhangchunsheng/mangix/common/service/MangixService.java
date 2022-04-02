package me.zhangchunsheng.mangix.common.service;

import me.zhangchunsheng.mangix.common.config.MangixConfig;
import me.zhangchunsheng.mangix.common.exception.MangixException;

import java.util.Map;

/**
 * <pre>
 * JumpServer
 * Created by Chunsheng Zhang on 2022/4/2.
 *
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public interface MangixService {

    /**
     * 获取JumpServer请求url前缀
     *
     * @return the jumpserver base url
     */
    String getBaseUrl();

    public MangixConfig getConfig();

    public void setConfig(MangixConfig config);

    public byte[] postForBytes(String url, String requestStr) throws MangixException;

    public String post(String url, String requestStr) throws MangixException;

    public String post(String url, Map<String, Object> params) throws MangixException;

    public String postJson(String url, String json, String privateToken) throws MangixException;

    public String postJson(String url, String csrfToken, String session, String json) throws MangixException;
    
    public String get(String url) throws MangixException;

    public String getJson(String url, String privateToken) throws MangixException;

}
