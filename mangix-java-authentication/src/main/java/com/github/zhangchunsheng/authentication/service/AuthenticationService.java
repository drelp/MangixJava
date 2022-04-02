package com.github.zhangchunsheng.authentication.service;

import com.github.zhangchunsheng.authentication.bean.result.LoginUrlResult;
import me.zhangchunsheng.mangix.common.exception.MangixException;
import me.zhangchunsheng.mangix.common.service.MangixService;

/**
 * <pre>
 * 手机归属地API
 * Created by Chunsheng Zhang on 2022/4/2.
 *
 * https://domain/api/v1/authentication/sso/login-url/
 *
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public interface AuthenticationService extends MangixService {

    /**
     * https://domain/api/v1/authentication/sso/login-url/
     * @param username
     * @param next
     * @return
     * @throws MangixException
     */
    public LoginUrlResult getLoginUrl(String username, String next) throws MangixException;

}
