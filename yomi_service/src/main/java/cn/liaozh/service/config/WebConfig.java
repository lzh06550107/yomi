package cn.liaozh.service.config;

import cn.liaozh.service.interceptor.UserFilter;
import cn.liaozh.service.interceptor.YmInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public WebConfig() {
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/img/**"}).addResourceLocations(new String[]{"file:/opt/yomi/"});
    }

    @Bean
    public YmInterceptor ymInterceptor() {
        return new YmInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.ymInterceptor()).addPathPatterns(new String[]{"/ym_server/**"}).excludePathPatterns(new String[]{"/ym_server/account/**"}).excludePathPatterns(new String[]{"/ym_server/config/msg"}).excludePathPatterns(new String[]{"/ym_server/ideafeedback/contact"});
    }

    @Bean
    public FilterRegistrationBean<UserFilter> httpServletRequestReplacedRegistration() {
        FilterRegistrationBean<UserFilter> registration = new FilterRegistrationBean();
        registration.setFilter(new UserFilter());
        registration.addUrlPatterns(new String[]{"/*"});
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("ymFilter");
        registration.setOrder(1);
        return registration;
    }
}
