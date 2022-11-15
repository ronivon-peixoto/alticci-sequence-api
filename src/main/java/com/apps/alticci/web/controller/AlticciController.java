package com.apps.alticci.web.controller;

import com.apps.alticci.service.AlticciService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/alticci")
@AllArgsConstructor
public class AlticciController {

    private final AlticciService alticciService;

    @GetMapping("{n}")
    public Long alticci(@PathVariable Integer n) {
        return alticciService.alticci(n);
    }

}
