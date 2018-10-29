package com.quicktron.wes.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月26日 18:42
 */
public class WCS {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String agvCode;

    public WCS() {}

    public WCS(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgvCode() {
        return agvCode;
    }

    public void setAgvCode(String agvCode) {
        this.agvCode = agvCode;
    }
}
