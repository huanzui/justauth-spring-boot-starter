package com.xkcoding.justauth;

import com.xkcoding.justauth.properties.JustAuthProperties;
import me.zhyd.oauth.cache.AuthDefaultStateCache;
import me.zhyd.oauth.cache.AuthStateCache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * JustAuth 自动装配类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-07-22 10:52
 */
@Configuration
@EnableConfigurationProperties(JustAuthProperties.class)
public class JustAuthAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "justauth", value = "enabled", havingValue = "true", matchIfMissing = true)
    public AuthRequestFactory authRequestFactory(JustAuthProperties properties, AuthStateCache authStateCache) {
        return new AuthRequestFactory(properties, authStateCache);
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthStateCache authStateCache() {
        return AuthDefaultStateCache.INSTANCE;
    }

}
