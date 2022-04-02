package me.zhangchunsheng.mangix.common.testbase;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import me.zhangchunsheng.mangix.common.config.MangixConfig;

/**
 * The type Xml Mangix config.
 */
@XStreamAlias("xml")
public class XmlMangixConfig extends MangixConfig {
    private String privateToken;
    private String baseUrl;

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Gets privateToken.
     *
     * @return the privateToken
     */
    public String getPrivateToken() {
        return privateToken;
    }

    /**
     * Sets privateToken.
     *
     * @param privateToken the privateToken
     */
    public void setPrivateToken(String privateToken) {
        this.privateToken = privateToken;
    }

}
