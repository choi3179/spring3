package com.spring3.core3.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/*
    간단하게 외부 네트워크에 미리 연결하는 객체를 하나 생성한다고 가정해보자.
    NetworkClient 는 애플리케이션 시작 시점에 connect() 를 호출해서 연결을 맺어두어야 하고,
    애플리케이션이 종료되면 disConnect() 를 호출해서 연결을 끊어야 한다.
 */
public class NetworkClient /*implements InitializingBean, DisposableBean*/ {
    private String url;
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + "// message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PreDestroy
    public void close() {
        System.out.println("Closing NetworkClient.destroy");
        disconnect();
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    /*
    // 빈이 종료되면... -> DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("Closing NetworkClient.destroy");
        disconnect();
    }

    // 의존관계 주입이 끝나면... -> InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }
    */
}
