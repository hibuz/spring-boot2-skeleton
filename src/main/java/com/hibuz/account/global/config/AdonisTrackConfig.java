package com.hibuz.account.global.config;

import com.woozooha.adonistrack.api.AdonisTrackHttpTraceFilter;
import com.woozooha.adonistrack.filter.AdonistrackFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.trace.http.HttpExchangeTracer;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AdonisTrackConfig {

    @Bean
    public HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }

    @Bean
    public FilterRegistrationBean<AdonisTrackHttpTraceFilter> adonisTrackHttpTraceFilter(HttpTraceRepository repository, HttpExchangeTracer tracer) {
        FilterRegistrationBean<AdonisTrackHttpTraceFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdonisTrackHttpTraceFilter(repository, tracer));
        registrationBean.addUrlPatterns("/api/**");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AdonistrackFilter> profileFilter() {
        FilterRegistrationBean<AdonistrackFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AdonistrackFilter());
        registrationBean.addUrlPatterns("/api/**");

        return registrationBean;
    }
}