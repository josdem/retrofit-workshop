package com.jos.dem.retrofit.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jos.dem.retrofit.workshop.model.PublicEmail;
import com.jos.dem.retrofit.workshop.service.UserService;

import retrofit2.Call;

@ContextConfiguration(classes = RetrofitWorkshopApplication.class)
@WebAppConfiguration
public class UserIntegrationTest {

  @Autowired
  private UserService userService;

  List<PublicEmail> getEmails() throws Exception {
    Call<List<PublicEmail>> call = userService.getEmails();
  }

}
