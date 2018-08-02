package com.jos.dem.retrofit.workshop;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

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

  private List<PublicEmail> emails = new ArrayList<PublicEmail>();
  private Logger log = LoggerFactory.getLogger(this.getClass());

  List<PublicEmail> getEmails() {
    Call<List<PublicEmail>> call = userService.getEmails();
    call.enqueue(new retrofit2.Callback<List<PublicEmail>>() {

      @Override
      public void onResponse(Call<List<PublicEmail>> call, Response<List<PublicEmail>> response) {
        emails = response.body();
      }

      @Override
      public void onFailure(Call<List<PublicEmail>> call, Throwable t) {
        log.info("error", t.getMessage());
      }

    });

    return emails;
  }

}
