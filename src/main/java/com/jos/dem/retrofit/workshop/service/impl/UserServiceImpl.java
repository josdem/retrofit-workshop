package com.jos.dem.retrofit.workshop.service.impl;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.retrofit.workshop.service.UserService;
import com.jos.dem.retrofit.workshop.model.PublicEmail;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private Retrofit retrofit;

  private UserService userService;

  @PostConstruct
  public void setup() {
    userService = retrofit.create(UserService.class);
  }

  public Call<List<PublicEmail>> getEmails() {
    return userService.getEmails();
  }

}
