package com.spring3.core3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/*
  의존관계 자동주입 관련 컴포넌트 스캔 테스트 설정 파일
 */
@Configuration
@ComponentScan(
        /*
            컴포넌트 스캔 시 컴포넌트 스캔 대상의 필터 지정
         */
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)   // @Component 붙은 모든 정보를 자동으로 등록시킴
    // @Configuration 에도 @Component 애노테이션이 지정되어 있음
public class AutoAppConfig {

}
