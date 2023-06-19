package com.spring3.core3.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

/*
    UUID 별로 HTTP 요청들을 구분 짓는 로그를 표시해본다.
    request 스코프 빈은 실제 HTTP 요청이 들어왔을 경우에만 생성됨을 확인한다. -> 에러 발생
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)   // 스코프를 request로 지정하여 빈이 HTTP 요청 당 하나 씩 생성되고 요청이 끝나면 소멸된다.
                                                                      // MyLogger의 가짜 프록시 클래스를 만들어두고 HTTP 요청과 상관없이 가짜 프록시 클래스를 다른 빈에 미리 주입할 수 있다.
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}
