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
import retrofit2.converter.gson.GsonConverterFactory;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class RetrofitWorkshopApplication {

  @Value("${github.api.url}")
  private String githubApiUrl;
  @Value("${token}")
  private String token;

  OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

  Interceptor interceptor = new Interceptor() {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
      Request request = chain.request().newBuilder().addHeader("Authorization", "token " + token).build();
      return chain.proceed(request);
    }
  };

  @Bean
  public Retrofit retrofit() {
    clientBuilder.interceptors().add(interceptor);
    return new Retrofit.Builder()
      .baseUrl(githubApiUrl)
      .client(clientBuilder.build())
      .addConverterFactory(GsonConverterFactory.create())
      .build();
  }

  public static void main(String[] args) {
    SpringApplication.run(RetrofitWorkshopApplication.class, args);
  }

}
