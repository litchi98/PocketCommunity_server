package com.litchi.pocketcommunity.config;

import com.litchi.pocketcommunity.util.JWTUtils;
import com.litchi.pocketcommunity.web.filter.JWTFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: JWTConfig
 * @Description: TODO
 * @author: litchi
 */
@Configuration
public class JWTConfig {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    private long expire;

    @Value("${jwt.authorised-urls}")
    private String[] authorisedUrls;

    @Bean
    public JWTUtils jwtHelperBean() {
        return new JWTUtils(secret, expire);
    }

    @Bean
    public FilterRegistrationBean basicFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JWTFilter filter = new JWTFilter(jwtHelperBean(), authorisedUrls);
        registrationBean.setFilter(filter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
