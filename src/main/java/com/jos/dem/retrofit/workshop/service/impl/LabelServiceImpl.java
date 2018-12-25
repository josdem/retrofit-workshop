package com.jos.dem.retrofit.workshop.service.impl;

import retrofit2.Call;
import retrofit2.Retrofit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.retrofit.workshop.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService {

  @Autowired
  private Retrofit retrofit;

  private LabelService labelService;

  @PostConstruct
  public void setup() {
    labelService = retrofit.create(LabelService.class);
  }

  public Call<LabelResponse> create() {
    return labelService.create();
  }

}