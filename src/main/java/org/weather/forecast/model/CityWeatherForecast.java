package org.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.weather.forecast.config.WeatherException;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityWeatherForecast {
    @JsonProperty("cod")
    private Integer cod;
    @JsonProperty("message")
    private Integer message;
    @JsonProperty("list")
    private List<Forecast> forecast;
    @JsonProperty("city")
    private City city;
    @JsonIgnore
    private WeatherException exception;

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public WeatherException getException() {
        return exception;
    }

    public void setException(WeatherException exception) {
        this.exception = exception;
    }
}
