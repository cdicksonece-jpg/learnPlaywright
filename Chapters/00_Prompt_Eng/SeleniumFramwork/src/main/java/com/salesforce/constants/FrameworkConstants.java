package com.salesforce.constants;

import java.time.Duration;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    public static final String BASE_URL = "https://login.salesforce.com/?locale=in";
    public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
    public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(15);
    public static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(30);

    public static final String ERROR_INVALID_CREDENTIALS = "Please check your username and password";
    public static final String ERROR_EMPTY_PASSWORD = "Please enter your password";
}
