package org.weather.forecast.data.client.fallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException.FeignClientException;
import org.weather.forecast.config.WeatherException;
import org.weather.forecast.data.cache.LocalCache;
import org.weather.forecast.data.client.OpenWeather;
import org.weather.forecast.model.CityWeatherForecast;
import org.weather.forecast.util.ExceptionType;

import java.nio.charset.StandardCharsets;

/**
 * Open weather fallback handler
 */
public class OpenWeatherFallback implements OpenWeather {

    private final Throwable cause;

    public OpenWeatherFallback(Throwable cause) {
        this.cause = cause;
    }

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Method to handle the fallback while fetching the CityForecast from the OpenWeather API
     * @param city - city name
     * @param appId - app id for authentication
     * @param count - number of forecast to be fetched
     * @return cityWeatherForecast
     */
    @Override
    public CityWeatherForecast getCityForecast(String city, String appId, Integer count) {
        WeatherException exception = convertToWeatherException((FeignClientException) cause);
        //If the service is unavailable the fallback will check for the data in local cache
        if (exception.getCode() == ExceptionType.SERVICE_UNAVAILABLE.getCode().intValue()) {
            return LocalCache.getInstance().get(city);
        } else {
            CityWeatherForecast forecast = new CityWeatherForecast();
            forecast.setException(new WeatherException(exception.getCode(), exception.getMessage(), exception.getCause()));
            return forecast;
        }
    }

    /**
     * Method to convert the FeignClientException response body to WeatherException
     * @param clientException  - FeignClientException
     * @return WeatherException
     */
    private WeatherException convertToWeatherException(FeignClientException clientException) {
        String exceptionJson = StandardCharsets.UTF_8.decode(clientException.responseBody().get()).toString();
        try {
            return mapper.readValue(exceptionJson, WeatherException.class);
        } catch (JsonProcessingException e) {
            return new WeatherException(ExceptionType.INTERNAL_SERVER_ERROR.getCode(), e.getMessage(), e.getCause());
        }
    }
}
