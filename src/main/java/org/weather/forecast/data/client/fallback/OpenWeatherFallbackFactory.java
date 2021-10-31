package org.weather.forecast.data.client.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.weather.forecast.data.client.OpenWeather;

/**
 * Open weather Fallback Factory
 */
@Component
public class OpenWeatherFallbackFactory implements FallbackFactory<OpenWeather> {
    @Override
    public OpenWeather create(Throwable cause) {
        return new OpenWeatherFallback(cause);
    }
}
