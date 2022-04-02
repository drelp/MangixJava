package me.zhangchunsheng.mangix.common.service.impl;

import me.zhangchunsheng.mangix.common.bean.MangixApiData;
import me.zhangchunsheng.mangix.common.config.MangixConfig;
import me.zhangchunsheng.mangix.common.service.MangixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * <pre>
 *  JumpServer接口请求抽象实现类
 *  Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public abstract class BaseServiceImpl implements MangixService {
    /**
     * The Log.
     */
    final Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * The constant mangixApiData.
     */
    static ThreadLocal<MangixApiData> mangixApiData = new ThreadLocal<>();

    /**
     * The Config.
     */
    protected MangixConfig config;

    @Override
    public MangixConfig getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(MangixConfig config) {
        this.config = config;
    }

    @Override
    public String getBaseUrl() {
        return this.getConfig().getBaseUrl();
    }

    /**
     * 只要确保你的编码输入是正确的,就可以忽略掉 UnsupportedEncodingException
     *
     * @param source 参数
     * @return String
     */
    public static String getUrlParams(Map<String, Object> source) {
        Iterator<String> it = source.keySet().iterator();
        StringBuilder paramStr = new StringBuilder();
        while (it.hasNext()) {
            String key = it.next();
            String value = source.get(key).toString();
            if (value.isEmpty()) {
                continue;
            }
            try {
                // URL 编码
                value = URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException e) {
                // do nothing
            }
            paramStr.append("&").append(key).append("=").append(value);
        }
        // 去掉第一个&
        return paramStr.substring(1);
    }
}
