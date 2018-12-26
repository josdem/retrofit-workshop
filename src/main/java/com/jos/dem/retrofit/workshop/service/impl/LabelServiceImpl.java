package com.jos.dem.retrofit.workshop.service.impl;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.Retrofit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.retrofit.workshop.model.Label;
import com.jos.dem.retrofit.workshop.model.LabelResponse;
import com.jos.dem.retrofit.workshop.service.LabelService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LabelServiceImpl implements LabelService {

  @Autowired
  private Retrofit retrofit;

  private LabelService labelService;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @PostConstruct
  public void setup() {
    labelService = retrofit.create(LabelService.class);
  }

  public Call<LabelResponse> create(@Body Label label) {
    log.info("Creating a new label : " + ToStringBuilder.reflectionToString(label));
    return labelService.create(label);
  }

}
