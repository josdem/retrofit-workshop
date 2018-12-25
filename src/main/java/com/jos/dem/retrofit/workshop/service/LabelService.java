package com.jos.dem.retrofit.workshop.service;

import retrofit2.Call;
import retrofit2.http.POST;

import com.jos.dem.retrofit.workshop.model.LabelResponse;

public interface LabelService {

  @POST("/repos/josdem/retrofit-workshop/labels")
  Call<LabelResponse> create();

}
