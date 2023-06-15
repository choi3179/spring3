package com.spring3.core3;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/*
    애노테이션 만들기
    @Qualifier 애노테이션 사용 시 문자타입이 컴파일에 잡히지 않는 불편함을 해소하기 위한 목적의 애노테이션 직접 만들기
    만든 애노테이션에 지정한 Qualifier를 사용하는 위치에 사용하면 기존 방법과 같은 효과를 낸다.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {

}
