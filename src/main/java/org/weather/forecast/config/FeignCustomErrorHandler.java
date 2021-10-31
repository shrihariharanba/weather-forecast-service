package org.weather.forecast.config;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Feign Error Handler class
 * This class is used for the feign error handler if circuit breaker is not enabled
 */
public class FeignCustomErrorHandler implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        return new WeatherException(response.status(), response.reason());
    }
}
