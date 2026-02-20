package com.hibuz.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootSkeletonApplication implements ApplicationRunner {
	@Value("${server.servlet.context-path:}")
	private String contextPath;

	@Value("${server.port}")
	private int serverPort;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSkeletonApplication.class, args);
	}

	@Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("http://localhost:{}{}/swagger-ui/index.html", serverPort, contextPath);
        log.info("http://localhost:{}{}/webjars/adonistrack-ui/html/invocations.html", serverPort, contextPath);

	}
}
