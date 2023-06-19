package com.spring3.core3.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

/*
    비즈니스 로직
 */
@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id) {
        //MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
