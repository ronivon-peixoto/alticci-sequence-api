package com.apps.alticci.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@Slf4j
public class AlticciServiceImpl implements AlticciService {

    @Lazy
    @Autowired
    private AlticciService self;

    @Override
    @Cacheable("alticci")
    public Long calculate(Integer index) {
        if (isNull(index) || index < 0) {
            throw new IllegalArgumentException("Must be greater than or equal to 0");
        }
        log.info("call of alticci with index {}", index);

        if (index == 0) {
            return 0L;
        } else if (index < 3) {
            return 1L;
        } else {
            return self.calculate(index - 3) + self.calculate(index - 2);
        }
    }

}
