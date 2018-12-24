package com.jos.dem.retrofit.workshop;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jos.dem.retrofit.workshop.model.SSHKey;
import com.jos.dem.retrofit.workshop.model.PublicEmail;
import com.jos.dem.retrofit.workshop.service.UserService;

import retrofit2.Call;
import retrofit2.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ContextConfiguration(classes = RetrofitWorkshopApplication.class)
@WebAppConfiguration
public class UserIntegrationTest {

  @Autowired
  private UserService userService;

  Call<List<SSHKey>> getKeys() {
    return userService.getKeys();
  }

  Call<List<PublicEmail>> getEmails(){
    return userService.getEmails();
  }

}
