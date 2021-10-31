package org.weather.forecast.data.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.weather.forecast.data.client.fallback.OpenWeatherFallbackFactory;
import org.weather.forecast.model.CityWeatherForecast;

/**
 * OpenWeather feign client to call the Open Weather apis
 */
@FeignClient(name = "OpenWeather", url = "${openweather.url}", fallbackFactory = OpenWeatherFallbackFactory.class)
public interface OpenWeather {

    /**
     * Api call to fetch the city weather forecast with the given count
     * @param city - city name
     * @param appId - app id for authentication
     * @param count - number of forecast to be fetched
     * @return CityWeatherForecast
     */
    @RequestMapping(value = "data/2.5/forecast?q={city}&appid={appId}&cnt{count}", method = RequestMethod.GET)
    public CityWeatherForecast getCityForecast(@RequestParam(value = "city") final String city,
                                               @RequestParam(value = "appId") final String appId,
                                               @RequestParam(value = "cnt") final Integer count);
}
