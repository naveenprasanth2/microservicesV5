package com.dailycodebuffer.serviceregistry.service;

import org.springframework.stereotype.Component;

@Component("implClasss")
public class ImplClasss implements SameInterface{
    @Override
    public void test() {
        System.out.println("impl classs");
    }
}
