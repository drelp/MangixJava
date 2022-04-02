package me.zhangchunsheng.mangix.common.config;

import org.testng.annotations.Test;

/**
 * <pre>
 *  Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class MangixConfigTest {
    private MangixConfig mangixConfig = new MangixConfig();

    @Test
    public void test1() throws Exception {
        mangixConfig.setPrivateToken("1");
        mangixConfig.setBaseUrl("https://www.google.com");
    }
}
