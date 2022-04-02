package me.zhangchunsheng.mangix.common.service.impl;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import me.zhangchunsheng.mangix.common.exception.MangixException;
import me.zhangchunsheng.mangix.common.service.MangixService;
import me.zhangchunsheng.mangix.common.testbase.ApiTestModule;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

/**
 * 测试相关接口
 * Created by Chunsheng Zhang on 2022/4/2.
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Slf4j
@Test
@Guice(modules = ApiTestModule.class)
public class BaseMangixServiceImplTest {

    @Inject
    private MangixService mangixService;

    @Test
    public void testPrivateToken() throws MangixException {
        String privateToken = this.mangixService.getConfig().getPrivateToken();
        assertNotNull(privateToken);
    }
}
