package com.quicktron.wes.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quicktron.wes.core.WCS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月27日 23:27
 */
@FeignClient(name = "wcs-service")
public interface WCSClient {

    @GetMapping("/v1/wcs/list")
    WCSDataResult listWCSs();

    @GetMapping("/v1/wcs/find/{id}")
    WCS get(@PathVariable("id") String id);

    class WCSDataResult {
        @JsonProperty
        private List<WCS> wcss;

        public List<WCS> getWcss() {
            return wcss;
        }

        public void setWcss(List<WCS> wcss) {
            this.wcss = wcss;
        }
    }
}
