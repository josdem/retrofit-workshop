package com.jos.dem.retrofit.workshop.service.impl;

import java.util.List;
import retrofit2.Call;

import org.springframework.stereotype.Service;
import com.jos.dem.retrofit.workshop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  public Call<List<List<PublicEmail>> getEmails() {

  }
}
