package com.apps.alticci.controller;

import com.apps.alticci.api.AlticciApi;
import com.apps.alticci.service.AlticciService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
@AllArgsConstructor
public class AlticciController implements AlticciApi {

    private final AlticciService alticciService;

    @Override
    public ResponseEntity<Long> getAlticciValueByIndex(Integer index) {
        return ResponseEntity.ok(alticciService.alticci(index));
    }
}
