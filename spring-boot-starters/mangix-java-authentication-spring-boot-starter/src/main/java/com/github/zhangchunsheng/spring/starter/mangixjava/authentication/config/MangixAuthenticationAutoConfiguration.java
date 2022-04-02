package com.github.zhangchunsheng.spring.starter.mangixjava.authentication.config;

import com.github.zhangchunsheng.authentication.service.AuthenticationService;
import com.github.zhangchunsheng.authentication.service.impl.AuthenticationServiceImpl;
import com.github.zhangchunsheng.spring.starter.mangixjava.authentication.properties.MangixAuthenticationProperties;
import me.zhangchunsheng.mangix.common.config.MangixConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *  JumpServer自动配置
 *  Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Configuration
@EnableConfigurationProperties(MangixAuthenticationProperties.class)
@ConditionalOnClass(AuthenticationService.class)
@ConditionalOnProperty(prefix = "jumpserver", value = "enabled", matchIfMissing = true)
public class MangixAuthenticationAutoConfiguration {
    private MangixAuthenticationProperties properties;

    @Autowired
    public MangixAuthenticationAutoConfiguration(MangixAuthenticationProperties properties) {
        this.properties = properties;
    }

    /**
     * 构造JumpServer地理服务对象.
     *
     * @return JumpServer地理service
     */
    @Bean
    @ConditionalOnMissingBean(AuthenticationService.class)
    public AuthenticationService authenticationService() {
        final AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();
        MangixConfig authenticationConfig = new MangixConfig();
        authenticationConfig.setPrivateToken(StringUtils.trimToNull(this.properties.getPrivateToken()));
        authenticationConfig.setBaseUrl(StringUtils.trimToNull(this.properties.getBaseUrl()));

        authenticationService.setConfig(authenticationConfig);
        return authenticationService;
    }
}
