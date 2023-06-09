package com.spring3.core3;


import com.spring3.core3.member.Grade;
import com.spring3.core3.member.Member;
import com.spring3.core3.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        //  AppConfig 설정을 스프링 기반의 애노테이션으로 적용할 경우
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //  스프링 빈으로 등록한 MemberService 객체를 불러옴
        //  기본적으로 빈으로 등록된 메소드명이 이름으로 등록됨
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
