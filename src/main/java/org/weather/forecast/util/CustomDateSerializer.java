package org.weather.forecast.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String fullDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        try {
            jsonGenerator.writeString(WeatherUtils.DATE_FORMAT.format(WeatherUtils.FULL_DATE_FORMAT.parse(fullDate)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
