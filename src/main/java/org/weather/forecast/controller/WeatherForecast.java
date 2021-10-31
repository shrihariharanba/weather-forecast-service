package org.weather.forecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.weather.forecast.model.CityForecast;
import org.weather.forecast.model.CityWeatherForecast;
import org.weather.forecast.service.WeatherForcastService;

import java.util.List;

@RestController
@RequestMapping("/forecast")
public class WeatherForecast {

    @Autowired
    WeatherForcastService service;

    @GetMapping(value = "/{city}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityForecast> getNextThreeDaysCityForecast(@PathVariable String city, @RequestParam(value = "cnt",defaultValue = "15") Integer count){
        return service.getNextThreeDaysCityForecast(city, count);
    }

}
