package com.apps.alticci.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlticciServiceImpl implements AlticciService {

    @Lazy
    @Autowired
    private AlticciService self;

    @Override
    @Cacheable("alticci")
    public Long alticci(Integer index) {
        log.info("call of alticci with index {}", index);

        if (index == 0) {
            return 0L;
        } else if (index < 3) {
            return 1L;
        } else {
            return self.alticci(index - 3) + self.alticci(index - 2);
        }
    }

}
