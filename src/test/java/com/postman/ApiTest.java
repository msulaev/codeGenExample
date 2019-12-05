package com.postman;

import com.postman.echo.ApiClient;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.junit.Before;
import org.junit.Test;

import static com.postman.echo.DogResponceAssert.assertThat;
import static feign.Feign.builder;


public class ApiTest {
    private ApiClient apiClient;

    @Before
    public void setUp() {
        apiClient = builder()
                .client(new OkHttpClient())
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(ApiClient.class, "https://dog.ceo");
    }

    @Test
    public void test() {
        assertThat(apiClient.getRandomImage()).hasNoNullFieldsOrPropertiesExcept();
    }

}
