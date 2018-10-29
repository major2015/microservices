package com.quicktron.basic.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月26日 17:50
 */
public class AGV {
    @JsonProperty
    private String id;
    @JsonProperty
    private String code;

    public AGV() {}

    public AGV(String id, String code) {
        this.id = id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
