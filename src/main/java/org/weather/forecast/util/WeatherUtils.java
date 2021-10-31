package org.weather.forecast.util;

import org.weather.forecast.model.CityForecast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WeatherUtils {
    public static Float KELVIN_CONSTANT = 273.15f;
    public static String THUNDERSTROM_DESCRIPTION = "Don’t step out! A Storm is brewing!";
    public static String WIND_VIOLATION_DESCRIPTION = "It’s too windy, watch out!";
    public static String WEATHER_THUNDERSTROM = "Thunderstorm";
    public static String WEATHER_RAIN = "Rain";
    public static String WEATHER_DESCRIPTION = "Carry Umbrella";
    public static Float SUMMER_TEMPERATURE = 40.00f;
    public static String SUMMER_DESCRIPTION = "Use sunscreen lotion";
    public static DateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static DateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm a");

    public static WeatherPrediction prediction = (forecast,cityName) -> {
        String climate = forecast.getWeather().get(0).getMain();
        String description = forecast.getWeather().get(0).getDescription();
        Float windSpeed = forecast.getWind().getSpeed();
        description = WEATHER_RAIN.equals(climate) ? WEATHER_DESCRIPTION : description;
        description = forecast.getMain().getTemperature() > SUMMER_TEMPERATURE ? SUMMER_DESCRIPTION : description;
        description = WEATHER_THUNDERSTROM.equals(climate) ? THUNDERSTROM_DESCRIPTION : description;
        description = windSpeed > 10 ? WIND_VIOLATION_DESCRIPTION : description;
        return new CityForecast(forecast.getMain().getTemperatureMax(),
                forecast.getMain().getTemperatureMin(),
                Math.round(forecast.getWind().getSpeed()),forecast.getWind().getDegree(), forecast.getDateText(), forecast.getDateText(), cityName, climate, description, forecast.getWeather().get(0).getIcon());
    };
}
