package org.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {
    @JsonProperty("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
}
