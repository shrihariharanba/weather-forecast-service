package org.weather.forecast.util;

/**
 * Handle different type of exception
 */
public enum ExceptionType {
    AUTHORIZATION(401, "Unauthorized"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    SERVICE_UNAVAILABLE(503, "Service unavailable");

    private final Integer code;
    private final String type;

    ExceptionType(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getType() {
        return this.type;
    }
}
