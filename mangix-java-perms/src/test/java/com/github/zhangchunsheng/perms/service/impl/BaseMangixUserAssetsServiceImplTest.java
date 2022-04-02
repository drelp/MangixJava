package com.github.zhangchunsheng.perms.service.impl;

import com.github.zhangchunsheng.perms.bean.result.UserAssetsResult;
import com.github.zhangchunsheng.perms.testbase.ApiTestModule;
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
public class BaseMangixUserAssetsServiceImplTest {

    @Inject
    private UserAssetsServiceImpl userAssetsServiceImpl;

    @Test
    public void testGetUserAssets() throws MangixException {
        UserAssetsResult result = this.userAssetsServiceImpl.getUserAssets(0, 15, 1, 1);
        assertEquals(200, result.getRetCode());
    }
}
