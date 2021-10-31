package org.weather.forecast.util;

import org.weather.forecast.model.CityForecast;
import org.weather.forecast.model.Forecast;

import java.util.List;

@FunctionalInterface
public interface WeatherPrediction {
    public CityForecast predict(Forecast forecast,String cityName);
}
