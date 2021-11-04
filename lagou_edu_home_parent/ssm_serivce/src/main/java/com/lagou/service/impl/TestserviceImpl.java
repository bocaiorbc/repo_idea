package com.lagou.service.impl;

import com.lagou.service.Testservice;
import com.lagou.dao.TestMapper;
import com.lagou.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestserviceImpl implements Testservice {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {
        List<Test> allTest = testMapper.findAllTest();
        return allTest;
    }
}
