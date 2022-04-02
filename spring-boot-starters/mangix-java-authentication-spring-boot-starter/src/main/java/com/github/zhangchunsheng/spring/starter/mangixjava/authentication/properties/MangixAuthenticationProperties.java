package com.github.zhangchunsheng.spring.starter.mangixjava.authentication.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <pre>
 *  JumpServer属性配置类
 *  Created by Chunsheng Zhang on 2022/4/2.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
@ConfigurationProperties(prefix = "jumpserver")
public class MangixAuthenticationProperties {
  /**
   * JumpServer privateToken.
   */
  private String privateToken;

  private String baseUrl;
}
