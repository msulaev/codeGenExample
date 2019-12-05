package com.postman;

import com.postman.echo.ApiClient;
import com.postman.echo.DogResponce;
import com.postman.echo.DogResponceAssert;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.junit.Test;


public class ApiTest {

    @Test
    public void test() {
        ApiClient apiClient = Feign.builder()
                .client(new OkHttpClient())
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .logger(new Slf4jLogger(ApiClient.class))
                .target(ApiClient.class, "https://dog.ceo");
        DogResponce test = apiClient.getBars();


        DogResponceAssert.assertThat(test).hasNoNullFieldsOrPropertiesExcept();
    }

}
