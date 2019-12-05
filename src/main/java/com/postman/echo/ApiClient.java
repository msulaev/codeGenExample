package com.postman.echo;

import feign.RequestLine;

public interface ApiClient {

    @RequestLine("GET /api/breeds/image/random")
    DogResponce getRandomImage();
}
