package org.weather.forecast.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.weather.forecast.config.WeatherException;
import org.weather.forecast.data.cache.LocalCache;
import org.weather.forecast.data.client.OpenWeather;
import org.weather.forecast.model.CityForecast;
import org.weather.forecast.model.CityWeatherForecast;
import org.weather.forecast.model.Forecast;
import org.weather.forecast.service.WeatherForcastService;
import org.weather.forecast.util.WeatherUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Weather forecast service
 */
@Service
public class WeatherForecastServiceImpl implements WeatherForcastService {

    @Autowired
    private OpenWeather openWeatherApi;

    @Value("${openweather.appId}")
    private String appId;

    /**
     * Method to fetch three days weather forecast of a city
     * @param city - city name
     * @param count - number of records need to be fetched
     * @return list of city forecast
     * @throws WeatherException
     */
    @Override
    public List<CityForecast> getNextThreeDaysCityForecast(String city, Integer count) throws WeatherException {
        CityWeatherForecast weatherForecast = openWeatherApi.getCityForecast(city, appId, count);
        if (weatherForecast != null && weatherForecast.getException() != null) {
            throw weatherForecast.getException();
        } else {
            LocalCache.getInstance().put(city, weatherForecast);
            return processForecastData(weatherForecast.getForecast(), city);
        }

    }

    /**
     * Method to process the forecast list
     * @param forecastList
     * @param cityName
     * @return list of city forecast
     */
    private List<CityForecast> processForecastData(List<Forecast> forecastList, String cityName) {
        return forecastList.stream().map(f -> WeatherUtils.prediction.predict(f, cityName)).collect(Collectors.toList());
    }
}
