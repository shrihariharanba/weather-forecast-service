package org.weather.forecast.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WeatherException to handle the runtime exception for the whole service
 */
public class WeatherException extends RuntimeException{

    @JsonProperty("cod")
    private Integer code;
    @JsonProperty("message")
    private String message;
    private Throwable cause;

    public WeatherException(){

    }

    public WeatherException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public WeatherException(Integer code, String message, Throwable cause) {
        super(message);
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}
