package com.apps.alticci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class AlticciServiceImpl implements AlticciService {

    @Lazy
    @Autowired
    private AlticciService self;

    @Override
    @Cacheable("alticci")
    public Long alticci(Integer n) {
        if (isNull(n) || n < 0) {
            throw new IllegalArgumentException("Invalid Argument");
        }
        System.out.println("call of alticci with index " + n);

        if (n == 0) {
            return 0L;
        } else if (n < 3) {
            return 1L;
        } else {
            return self.alticci(n - 3) + self.alticci(n - 2);
        }
    }

}
