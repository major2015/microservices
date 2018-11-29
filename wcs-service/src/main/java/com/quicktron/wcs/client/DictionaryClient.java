package com.quicktron.wcs.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年11月29日 10:22
 */
@FeignClient(name = "internationalization")
public interface DictionaryClient {
    @GetMapping("/dictionary/zh")
    Map<String, Object> listZH();

    @GetMapping("/dictionary/en")
    Map<String, Object> listEN();
}
