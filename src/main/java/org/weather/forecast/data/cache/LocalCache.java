package org.weather.forecast.data.cache;

import org.weather.forecast.model.CityWeatherForecast;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Singleton cache saves all the latest city forecast data
 */
public class LocalCache {
    private Map<String, CityWeatherForecast> CACHE;
    private static LocalCache INSTANCE = new LocalCache();

    private LocalCache() {
        CACHE = new ConcurrentHashMap<>();
    }

    public static LocalCache getInstance() {
        return INSTANCE;
    }

    public void put(String key, CityWeatherForecast value) {
        CACHE.put(key, value);
    }

    public CityWeatherForecast get(String key) {
        return CACHE.get(key);
    }
}
