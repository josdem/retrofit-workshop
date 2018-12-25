package com.jos.dem.retrofit.workshop.service;

public interface LabelService {

  @POST("/repos/josdem/retrofit-workshop/labels")
  Call<LabelResponse> create();

}
