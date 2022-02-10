package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.*;

public class Utils {
    public static RequestSpecification getRequestSpecification() throws IOException {
        PrintStream printStream = new PrintStream(new File("output.txt"));
        return new RequestSpecBuilder().setBaseUri(getGlobalVar("baseUrl"))
                                       .addFilter(RequestLoggingFilter.logRequestTo(printStream))
                                       .addQueryParam("key", "qaclick123")
                                       .addFilter(ResponseLoggingFilter.logResponseTo(printStream))
                                       .setContentType(ContentType.JSON).build();
    }

    public static String getGlobalVar(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(
            "/Users/veronika_chukhalova/Downloads/cucumber-java-skeleton-main/src/main/java/resources/global.properties");
        properties.load(fileInputStream);
        return (String) properties.get(key);
    }
}
