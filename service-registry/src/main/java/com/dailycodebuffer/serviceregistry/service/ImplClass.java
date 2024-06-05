package com.dailycodebuffer.serviceregistry.service;

import org.springframework.stereotype.Component;

@Component("implClass")
public class ImplClass implements SameInterface{
    public void test(){
        System.out.println("impl class");
    }
}
