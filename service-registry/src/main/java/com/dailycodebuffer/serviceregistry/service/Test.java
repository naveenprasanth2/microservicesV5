package com.dailycodebuffer.serviceregistry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class Test {
    @Autowired
    @Qualifier("implClass")
    private ImplClass implClass;
}
