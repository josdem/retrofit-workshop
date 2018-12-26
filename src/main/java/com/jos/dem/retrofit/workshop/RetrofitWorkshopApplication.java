package com.jos.dem.retrofit.workshop;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;

import org.springframework.util.Base64Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class RetrofitWorkshopApplication {

  @Value("${github.api.url}")
  private String githubApiUrl;
  @Value("${username}")
  private String username;
  @Value("${token}")
  private String token;

  private OkHttpClient.Builder buildClient() {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(new Interceptor() {
      @Override
      public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader("Authorization", "Basic " + Base64Utils
            .encodeToString((username + ":" + token).getBytes(UTF_8))).build();
        return chain.proceed(request);
      }
    });
    return httpClient;
  }

  @Bean
  public Retrofit retrofit() {
    return new Retrofit.Builder()
      .baseUrl(githubApiUrl)
      .addConverterFactory(JacksonConverterFactory.create())
      .client(buildClient().build())
      .build();
  }

  public static void main(String[] args) {
    SpringApplication.run(RetrofitWorkshopApplication.class, args);
  }

}
