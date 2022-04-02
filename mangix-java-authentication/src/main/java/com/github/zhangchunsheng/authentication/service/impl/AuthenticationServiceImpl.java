package com.github.zhangchunsheng.authentication.service.impl;

import com.github.zhangchunsheng.authentication.bean.request.LoginUrlRequest;
import com.github.zhangchunsheng.authentication.bean.result.LoginUrlResult;
import com.github.zhangchunsheng.authentication.service.AuthenticationService;
import me.zhangchunsheng.mangix.common.constant.MangixConstants;
import me.zhangchunsheng.mangix.common.exception.MangixException;
import me.zhangchunsheng.mangix.common.service.impl.MangixServiceApacheHttpImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * <pre>
 * JumpServer接口请求实现类，默认使用Apache HttpClient实现
 * Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class AuthenticationServiceImpl extends MangixServiceApacheHttpImpl implements AuthenticationService {
    @Override
    public LoginUrlResult getLoginUrl(String username, String next) throws MangixException {
        try {
            // URL 编码
            username = URLEncoder.encode(username, "utf-8");
            next = URLEncoder.encode(next, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // do nothing
        }

        LoginUrlRequest loginUrlRequest = new LoginUrlRequest();
        loginUrlRequest.setUsername(username);
        loginUrlRequest.setNext(next);
        String requestStr = loginUrlRequest.toString();

        String responseContent = this.postJson(this.getConfig().getBaseUrl() + MangixConstants.Url.LOGIN_URL, requestStr, this.getConfig().getPrivateToken());
        return LoginUrlResult.fromJson(responseContent);
    }
}
