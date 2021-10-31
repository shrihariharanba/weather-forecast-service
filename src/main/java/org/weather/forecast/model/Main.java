package org.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.weather.forecast.util.WeatherUtils;

public class Main {

    @JsonProperty("temp")
    private Float temperature;
    @JsonProperty("feels_like")
    private Float feelsLike;
    @JsonProperty("temp_min")
    private Float temperatureMin;
    @JsonProperty("temp_max")
    private Float temperatureMax;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("sea_level")
    private Integer seaLevel;
    @JsonProperty("grnd_level")
    private Integer groundLevel;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("temp_kf")
    private Float tempKf;

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature - WeatherUtils.KELVIN_CONSTANT;
    }

    public Float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Float feelsLike) {
        this.feelsLike = feelsLike - WeatherUtils.KELVIN_CONSTANT;
    }

    public Float getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Float temperatureMin) {
        this.temperatureMin = temperatureMin - WeatherUtils.KELVIN_CONSTANT;
    }

    public Float getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Float temperatureMax) {
        this.temperatureMax = temperatureMax - WeatherUtils.KELVIN_CONSTANT;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Integer seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Integer getGroundLevel() {
        return groundLevel;
    }

    public void setGroundLevel(Integer groundLevel) {
        this.groundLevel = groundLevel;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Float getTempKf() {
        return tempKf;
    }

    public void setTempKf(Float tempKf) {
        this.tempKf = tempKf;
    }
}
