package com.quicktron.wes.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ${DESCRIPTION}
 *
 * @author lance xu
 * @date2018年10月27日 23:15
 */
public class WES {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String agvCode;
    @JsonProperty
    private String wcsName;

    public WES() {}

    public WES(String id, String name) {
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

    public String getWcsName() {
        return wcsName;
    }

    public void setWcsName(String wcsName) {
        this.wcsName = wcsName;
    }
}
