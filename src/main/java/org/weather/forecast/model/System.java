package org.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class System {
    @JsonProperty("pod")
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
