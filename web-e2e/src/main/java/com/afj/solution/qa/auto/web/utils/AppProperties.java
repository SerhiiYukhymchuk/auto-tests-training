package com.afj.solution.qa.auto.web.utils;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public final class AppProperties {
    public static final String BROWSER = System.getProperty("browser", "chrome");
    public static final String HEADLESS = System.getProperty("headless", "true");
    public static final String BASE_URL = System.getProperty("base.url", "http://localhost:3000");
    public static final String ADMIN_MAIL = "serhii.yukhymchuk@idealscorp.com";
    public static final String USER_MAIL = "heavysergey@ukr.net";
    public static final String PASSWORD = "qa456Q@123";

    private AppProperties() {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}
