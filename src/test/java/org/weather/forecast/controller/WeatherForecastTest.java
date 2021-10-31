package org.weather.forecast.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.weather.forecast.model.CityForecast;
import org.weather.forecast.service.impl.WeatherForecastServiceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherForecastTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherForecastServiceImpl service;

    List<CityForecast> list = null;

    @Before
    public void init() throws JsonProcessingException {
        list = Arrays.asList(mapper.readValue(data(), CityForecast[].class));
    }

    @Test
    public void testNextThreeDaysCityForecast() throws Exception {
        when(service.getNextThreeDaysCityForecast(anyString(),anyInt())).thenReturn(list);
        mockMvc.perform(get("/forecast/chennai"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2  )))
                .andExpect(jsonPath("$[0].city", is("chennai")))
                .andExpect(jsonPath("$[0].climate", is("Rain")))
                .andExpect(jsonPath("$[1].city", is("chennai")))
                .andExpect(jsonPath("$[1].climate", is("Rain")));
        verify(service, times(1)).getNextThreeDaysCityForecast("chennai",15);

    }


    private String data() {
        return "[{\n" +
                "        \"highTemp\": \"30.06\",\n" +
                "        \"lowTemp\": \"28.19\",\n" +
                "        \"dateText\": \"2021-10-31 12:00:00\",\n" +
                "        \"timeText\": \"2021-10-31 12:00:00\",\n" +
                "        \"city\": \"chennai\",\n" +
                "        \"climate\": \"Rain\",\n" +
                "        \"description\": \"Carry Umbrella\",\n" +
                "        \"icon\": \"10d\",\n" +
                "        \"windSpeed\": 5,\n" +
                "        \"degree\": 40\n" +
                "    },\n" +
                "    {\n" +
                "        \"highTemp\": \"28.54\",\n" +
                "        \"lowTemp\": \"27.32\",\n" +
                "        \"dateText\": \"2021-10-31 15:00:00\",\n" +
                "        \"timeText\": \" 2021-10-31 15:00:00\",\n" +
                "        \"city\": \"chennai\",\n" +
                "        \"climate\": \"Rain\",\n" +
                "        \"description\": \"Carry Umbrella\",\n" +
                "        \"icon\": \"10n\",\n" +
                "        \"windSpeed\": 4,\n" +
                "        \"degree\": 44\n" +
                "    }]";
    }
}
