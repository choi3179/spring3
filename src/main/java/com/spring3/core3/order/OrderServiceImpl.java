package com.spring3.core3.order;

import com.spring3.core3.discount.DiscountPolicy;
import com.spring3.core3.discount.FixDiscountPolicy;
import com.spring3.core3.discount.RateDiscountPolicy;
import com.spring3.core3.member.Member;
import com.spring3.core3.member.MemberRepository;
import com.spring3.core3.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);     //  단일 책임 원칙을 잘 준수된 설계(할인 정책에 대해 다른 구현체의 결과만 받아옴)
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
