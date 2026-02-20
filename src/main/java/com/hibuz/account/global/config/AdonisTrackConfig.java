package com.hibuz.account.global.config;

import com.woozooha.adonistrack.api.AdonisTrackHttpTraceFilter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.trace.http.HttpExchangeTracer;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AdonisTrackConfig {
	@Value("${server.servlet.context-path:}")
	private String contextPath;
    
    @Bean
    public HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }

    @Bean
    public FilterRegistrationBean<AdonisTrackHttpTraceFilter> adonisTrackHttpTraceFilter(HttpTraceRepository repository, HttpExchangeTracer tracer) {
        FilterRegistrationBean<AdonisTrackHttpTraceFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdonisTrackHttpTraceFilter(repository, tracer));
        registrationBean.addUrlPatterns(contextPath + "/api/*", contextPath + "/open/*");

        return registrationBean;
    }
}