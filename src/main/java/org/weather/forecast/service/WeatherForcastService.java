package org.weather.forecast.service;

import org.weather.forecast.config.WeatherException;
import org.weather.forecast.model.CityForecast;
import org.weather.forecast.model.CityWeatherForecast;
import org.weather.forecast.model.Forecast;

import java.util.List;

public interface WeatherForcastService {
    public List<CityForecast> getNextThreeDaysCityForecast(String city, Integer count) throws WeatherException;
}
