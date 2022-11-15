package com.apps.alticci.service;

import com.apps.alticci.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class AlticciServiceImpl implements AlticciService {

    private static final Integer MAX_INDEX_ALLOWED = 435;
    @Lazy
    @Autowired
    private AlticciService self;

    @Override
    @Cacheable("alticci")
    public Long alticci(Integer index) {
        validateIndex(index);
        log.info("call of alticci with index {}", index);

        if (index == 0) {
            return 0L;
        } else if (index < 3) {
            return 1L;
        } else {
            return self.alticci(index - 3) + self.alticci(index - 2);
        }
    }

    private static void validateIndex(Integer index) {
        if (index > MAX_INDEX_ALLOWED) { // above indexes result in values exceeding the capacity of type 'java.lang.Long'
            throw new BusinessException(format("%s is the highest index value allowed so far", MAX_INDEX_ALLOWED));
        }
    }

}
