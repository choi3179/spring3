package com.spring3.core3.common;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    MyLogger 작동을 확인하기 위한 컨트롤러 작성
    HttpServletRequest를 통해 요청 URL를 받는다.
 */
@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        //MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURL().toString();
        /*
            CGLIB 라이브러리 내 클래스를 상속받은 가짜 프록시 객체를 만들어서 주입한 것을 확인한다.
            가짜 프록시 객체는 원본 클래스를 상속 받아 만들어짐 -> 요청에 대해 실제 빈을 호출하는 위임로직 존재
            -> 클라이언트는 원본인지 가짜인지 모르고 사용 가능 -> 다형성
         */
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
