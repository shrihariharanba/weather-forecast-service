package org.weather.forecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.weather.forecast.model.CityForecast;
import org.weather.forecast.model.CityWeatherForecast;
import org.weather.forecast.service.WeatherForcastService;

import java.util.List;

/**
 * WeatherForecast Controller
 */
@RestController
@RequestMapping("/forecast")
public class WeatherForecast {

    @Autowired
    WeatherForcastService service;

    /**
     * API to fetch three days weather forecast
     * @param city - city name
     * @param count - forecast count
     * @return list of CityForecast
     */
    @GetMapping(value = "/{city}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityForecast> getNextThreeDaysCityForecast(@PathVariable String city, @RequestParam(value = "cnt",defaultValue = "15") Integer count){
        return service.getNextThreeDaysCityForecast(city, count);
    }

}
