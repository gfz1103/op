package com.buit.cis.op.dctwork.ybtspost.service;

import com.buit.utill.HttpClientUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

@Async
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    public void doPost(String url, Map message) {
        HttpClientUtil.doPost(url,message);
    }
}
