package com.spring3.core3;

import com.spring3.core3.discount.DiscountPolicy;
import com.spring3.core3.discount.FixDiscountPolicy;
import com.spring3.core3.discount.RateDiscountPolicy;
import com.spring3.core3.member.MemberRepository;
import com.spring3.core3.member.MemberService;
import com.spring3.core3.member.MemberServiceImpl;
import com.spring3.core3.member.MemoryMemberRepository;
import com.spring3.core3.order.OrderService;
import com.spring3.core3.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy(), memberRepository());
        //return null;
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
