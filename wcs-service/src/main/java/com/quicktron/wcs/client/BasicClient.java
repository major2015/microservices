package com.quicktron.wcs.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quicktron.wcs.core.AGV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月27日 1:01
 */
@FeignClient(name = "basic-service")
public interface BasicClient {
    @GetMapping("/v1/agv/list")
    AGVResult listAGVs();

    class AGVResult {
        @JsonProperty
        private List<AGV> agvs;

        public List<AGV> getAgvs() {
            return agvs;
        }

        public void setAgvs(List<AGV> agvs) {
            this.agvs = agvs;
        }
    }
}
