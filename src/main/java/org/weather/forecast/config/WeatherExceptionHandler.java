package org.weather.forecast.config;

import feign.FeignException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(annotations = RestController.class)
@Component
public class WeatherExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = WeatherException.class)
    public void resolveException(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Exception exception) {
        if(exception instanceof WeatherException) {
            WeatherException e = (WeatherException) exception;
            response.setStatus(e.getCode());
            response.setHeader("Error-Message",e.getMessage());
        }else if(exception instanceof FeignException) {
            FeignException e = (FeignException) exception;
            response.setStatus(e.status());
            response.setHeader("Error-Message",e.getMessage());
        } else {
            exception.printStackTrace();
            response.setStatus(500);
            response.setHeader("Error-Message", exception.getMessage());
        }
    }
}
