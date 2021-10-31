package org.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    @JsonProperty("3h")
    private Integer threeHours;

    public Integer getThreeHours() {
        return threeHours;
    }

    public void setThreeHours(Integer threeHours) {
        this.threeHours = threeHours;
    }
}
