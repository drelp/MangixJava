package com.github.zhangchunsheng.authentication.service.impl;

import com.github.zhangchunsheng.authentication.bean.result.LoginUrlResult;
import com.github.zhangchunsheng.authentication.service.AuthenticationService;
import com.github.zhangchunsheng.authentication.testbase.ApiTestModule;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import me.zhangchunsheng.mangix.common.exception.MangixException;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * 测试相关接口
 * Created by Chunsheng Zhang on 2022/4/2.
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Slf4j
@Test
@Guice(modules = ApiTestModule.class)
public class BaseMangixAuthenticationServiceImplTest {

    @Inject
    private AuthenticationService authenticationService;

    @Test
    public void testLoginUrl() throws MangixException {
        // 【响应数据】：{"error": "Not found"}
        // {"username": "test", "next": "/luna/"}
        // {"username":"test","next":"%2Fluna%2F"}
        LoginUrlResult result = this.authenticationService.getLoginUrl("test", "/luna/");
        assertEquals(200, result.getRetCode());
    }
}
