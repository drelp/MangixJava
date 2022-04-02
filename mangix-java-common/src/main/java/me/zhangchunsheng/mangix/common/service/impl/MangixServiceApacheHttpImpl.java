package me.zhangchunsheng.mangix.common.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jodd.util.Base64;
import me.zhangchunsheng.mangix.common.bean.MangixApiData;
import me.zhangchunsheng.mangix.common.exception.MangixException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * JumpServer请求实现类，apache httpclient实现.
 * Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class MangixServiceApacheHttpImpl extends BaseServiceImpl {
    private static Logger logger = LoggerFactory.getLogger(MangixServiceApacheHttpImpl.class);

    @Override
    public byte[] postForBytes(String url, String requestStr) throws MangixException {
        try {
            HttpClientBuilder httpClientBuilder = createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    final byte[] bytes = EntityUtils.toByteArray(response.getEntity());
                    final String responseData = Base64.encodeToString(bytes);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据(Base64编码后)】：{}", url, requestStr, responseData);
                    mangixApiData.set(new MangixApiData(url, requestStr, responseData, null));
                    return bytes;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            mangixApiData.set(new MangixApiData(url, requestStr, null, e.getMessage()));
            throw new MangixException(e.getMessage(), e);
        }
    }

    @Override
    public String get(String url) throws MangixException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpGet httpGet = this.createHttpGet(url);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, "", responseString);
                    if (this.getConfig().isIfSaveApiData()) {
                        mangixApiData.set(new MangixApiData(url, "", responseString, null));
                    }
                    return responseString;
                }
            } finally {
                httpGet.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, "", e.getMessage());
            if (this.getConfig().isIfSaveApiData()) {
                mangixApiData.set(new MangixApiData(url, "", null, e.getMessage()));
            }
            throw new MangixException(e.getMessage(), e);
        }
    }

    @Override
    public String getJson(String url, String privateToken) throws MangixException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpGet httpGet = this.createHttpGet(url);
            httpGet.setHeader("Content-Type", "application/json");
            httpGet.setHeader("Authorization", "Token " + privateToken);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, "", responseString);
                    if (this.getConfig().isIfSaveApiData()) {
                        mangixApiData.set(new MangixApiData(url, "", responseString, null));
                    }
                    return responseString;
                }
            } finally {
                httpGet.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, "", e.getMessage());
            if (this.getConfig().isIfSaveApiData()) {
                mangixApiData.set(new MangixApiData(url, "", null, e.getMessage()));
            }
            throw new MangixException(e.getMessage(), e);
        }
    }

    @Override
    public String post(String url, String requestStr) throws MangixException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);
                    if (this.getConfig().isIfSaveApiData()) {
                        mangixApiData.set(new MangixApiData(url, requestStr, responseString, null));
                    }
                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            if (this.getConfig().isIfSaveApiData()) {
                mangixApiData.set(new MangixApiData(url, requestStr, null, e.getMessage()));
            }
            throw new MangixException(e.getMessage(), e);
        }
    }

    @Override
    public String post(String url, Map<String, Object> params) throws MangixException {
        String requestStr = MangixServiceApacheHttpImpl.getUrlParams(params);
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, params);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);
                    if (this.getConfig().isIfSaveApiData()) {
                        mangixApiData.set(new MangixApiData(url, requestStr, responseString, null));
                    }
                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            if (this.getConfig().isIfSaveApiData()) {
                mangixApiData.set(new MangixApiData(url, requestStr, null, e.getMessage()));
            }
            throw new MangixException(e.getMessage(), e);
        }
    }

    @Override
    public String postJson(String url, String requestStr, String privateToken) throws MangixException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPostJson(url, requestStr, privateToken);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);
                    if (this.getConfig().isIfSaveApiData()) {
                        mangixApiData.set(new MangixApiData(url, requestStr, responseString, null));
                    }
                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            if (this.getConfig().isIfSaveApiData()) {
                mangixApiData.set(new MangixApiData(url, requestStr, null, e.getMessage()));
            }
            throw new MangixException(e.getMessage(), e);
        }
    }

    @Override
    public String postJson(String url, String csrfToken, String session, String requestStr) throws MangixException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPostJson(url, csrfToken, session, requestStr);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);
                    if (this.getConfig().isIfSaveApiData()) {
                        mangixApiData.set(new MangixApiData(url, requestStr, responseString, null));
                    }
                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            if (this.getConfig().isIfSaveApiData()) {
                mangixApiData.set(new MangixApiData(url, requestStr, null, e.getMessage()));
            }
            throw new MangixException(e.getMessage(), e);
        }
    }

    private StringEntity createEntry(String requestStr) {
        try {
            return new StringEntity(new String(requestStr.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        } catch (UnsupportedEncodingException e) {
            //cannot happen
            this.log.error(e.getMessage(), e);
            return null;
        }
    }

    private HttpClientBuilder createHttpClientBuilder() throws MangixException {
        HttpClientBuilder httpClientBuilder = HttpClients.custom();

        if (StringUtils.isNotBlank(this.getConfig().getHttpProxyHost()) && this.getConfig().getHttpProxyPort() > 0) {
            if (StringUtils.isEmpty(this.getConfig().getHttpProxyUsername())) {
                this.getConfig().setHttpProxyUsername("whatever");
            }

            // 使用代理服务器 需要用户认证的代理服务器
            CredentialsProvider provider = new BasicCredentialsProvider();
            provider.setCredentials(new AuthScope(this.getConfig().getHttpProxyHost(), this.getConfig().getHttpProxyPort()),
                    new UsernamePasswordCredentials(this.getConfig().getHttpProxyUsername(), this.getConfig().getHttpProxyPassword()));
            httpClientBuilder.setDefaultCredentialsProvider(provider);
            httpClientBuilder.setProxy(new HttpHost(this.getConfig().getHttpProxyHost(), this.getConfig().getHttpProxyPort()));
        }
        return httpClientBuilder;
    }

    private HttpPost createHttpPost(String url, String requestStr) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(this.createEntry(requestStr));

        httpPost.setConfig(RequestConfig.custom()
                .setConnectionRequestTimeout(this.getConfig().getHttpConnectionTimeout())
                .setConnectTimeout(this.getConfig().getHttpConnectionTimeout())
                .setSocketTimeout(this.getConfig().getHttpTimeout())
                .build());

        return httpPost;
    }

    private HttpPost createHttpPostJson(String url, String requestStr, String privateToken) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Token " + privateToken);
        StringEntity s = new StringEntity(requestStr, "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                "application/json"));
        httpPost.setEntity(s);

        httpPost.setConfig(RequestConfig.custom()
                .setConnectionRequestTimeout(this.getConfig().getHttpConnectionTimeout())
                .setConnectTimeout(this.getConfig().getHttpConnectionTimeout())
                .setSocketTimeout(this.getConfig().getHttpTimeout())
                .build());

        return httpPost;
    }

    private HttpPost createHttpPostJson(String url, String csrfToken, String session, String requestStr) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("X-CSRF-TOKEN", csrfToken);
        httpPost.setHeader("Cookie", "ZSMART_LOCALE=zh; SESSION=" + session);
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_1_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
        StringEntity s = new StringEntity(requestStr, "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                "application/json"));
        httpPost.setEntity(s);

        httpPost.setConfig(RequestConfig.custom()
                .setConnectionRequestTimeout(this.getConfig().getHttpConnectionTimeout())
                .setConnectTimeout(this.getConfig().getHttpConnectionTimeout())
                .setSocketTimeout(this.getConfig().getHttpTimeout())
                .build());

        return httpPost;
    }

    private HttpPost createHttpPost(String url, Map<String, Object> reqMap) {
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();

        HttpEntity httpEntity = this.createHttpEntity(reqMap);
        httpPost.setEntity(httpEntity);
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");

        return httpPost;
    }

    private HttpEntity createHttpEntity(Map<String, Object> reqMap) {
        HttpEntity reqEntity = null;
        try {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();

            Iterator iterator = reqMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            reqEntity = new UrlEncodedFormEntity(formParams, "utf-8");
        } catch (UnsupportedEncodingException e) {
            this.log.error(e.toString());
        }
        return reqEntity;
    }

    private HttpGet createHttpGet(String url) {
        HttpGet httpGet = new HttpGet(url);

        httpGet.setConfig(RequestConfig.custom()
                .setConnectionRequestTimeout(this.getConfig().getHttpConnectionTimeout())
                .setConnectTimeout(this.getConfig().getHttpConnectionTimeout())
                .setSocketTimeout(this.getConfig().getHttpTimeout())
                .build());

        return httpGet;
    }

    /**
     * getUri
     *
     * @param url URI
     * @param reqMap 请求参数
     * @return String
     */
    public static String getUri(String url, Map<String, Object> reqMap) {
        URIBuilder uri = null;
        try {
            uri = new URIBuilder(url);
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();

            Iterator iterator = reqMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            uri.addParameters(formParams);

            return uri.build().toString();
        } catch (URISyntaxException e) {
            logger.error(e.toString());
        }
        return url;
    }

    /**
     * getPostHttpEntity
     *
     * @param reqMap 请求参数
     * @return HttpEntity
     */
    public static HttpEntity getPostHttpEntity(Map<String, Object> reqMap) {
        HttpEntity reqEntity = null;
        try {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();

            Iterator iterator = reqMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            reqEntity = new UrlEncodedFormEntity(formParams, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.toString());
        }
        return reqEntity;
    }
}
