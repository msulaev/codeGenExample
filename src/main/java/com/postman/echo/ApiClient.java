package com.postman.echo;

import feign.Headers;
import feign.RequestLine;

public interface ApiClient {

    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/breeds/image/random")
    DogResponce getBars();
}
