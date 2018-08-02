package com.jos.dem.retrofit.workshop.service.impl;

import java.util.List;
import retrofit2.Call;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import com.jos.dem.retrofit.workshop.service.UserService;

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
