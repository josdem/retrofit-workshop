package com.jos.dem.retrofit.workshop.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import com.jos.dem.retrofit.workshop.model.PublicEmail;

public interface UserService {

  @GET("user/public_emails")
  Call<List<PublicEmail>> getEmails();

}
