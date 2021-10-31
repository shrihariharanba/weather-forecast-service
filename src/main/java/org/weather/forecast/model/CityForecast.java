package org.weather.forecast.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.weather.forecast.util.CustomDateSerializer;
import org.weather.forecast.util.CustomFloatSerializer;
import org.weather.forecast.util.CustomTimeSerializer;

public class CityForecast {
    @JsonSerialize(using  = CustomFloatSerializer.class)
    private Float highTemp;
    @JsonSerialize(using  = CustomFloatSerializer.class)
    private Float lowTemp;
    @JsonSerialize(using = CustomDateSerializer.class)
    private String dateText;
    @JsonSerialize(using = CustomTimeSerializer.class)
    private String timeText;
    private String city;
    private String climate;
    private String description;
    private String icon;
    private Integer windSpeed;
    private Integer degree;

    public CityForecast(Float highTemp, Float lowTemp, Integer windSpeed,Integer degree, String dateText, String timeText, String city, String climate, String description, String icon) {
        this.highTemp = highTemp;
        this.lowTemp = lowTemp;
        this.windSpeed = windSpeed;
        this.degree = degree;
        this.dateText = dateText;
        this.timeText = timeText;
        this.city = city;
        this.climate = climate;
        this.description = description;
        this.icon = icon;
    }

    public CityForecast() {
    }

    public Float getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(Float highTemp) {
        this.highTemp = highTemp;
    }

    public Float getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(Float lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getDateText() {
        return dateText;
    }

    public void setDateText(String dateText) {
        this.dateText = dateText;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getTimeText() {
        return timeText;
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }
}
