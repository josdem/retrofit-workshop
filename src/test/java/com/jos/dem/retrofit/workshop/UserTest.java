package com.jos.dem.retrofit.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;

import retrofit2.Call;
import retrofit2.Response;

import com.jos.dem.retrofit.workshop.model.PublicEmail;
import com.jos.dem.retrofit.workshop.service.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTest extends UserIntegrationTest {

  @Autowired
  private UserService userService;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @When("User call to get his public keys")
  public void shouldGetKeys() throws Exception {
    log.info("Running: User gets his SSH keys");

    Call<List<PublicEmail>> call = userService.getEmails();
  }

  @Then("^User gets his public emails$")
  public void shouldGetEmails() throws Exception {
    log.info("Validating collection integrity");

    Call<List<PublicEmail>> call = userService.getEmails();
    call.enqueue(new retrofit2.Callback<List<PublicEmail>>() {

      @Override
      public void onResponse(Call<List<PublicEmail>> call, Response<List<PublicEmail>> response) {
        List<PublicEmail> emails = response.body();
        assertFalse(emails.isEmpty(), () -> "Should not be empty");
        assertTrue(emails.size() == 1,  () -> "Should be 1 email");

        PublicEmail email = emails.get(0);
        log.info("Validating email attributes");
        assertAll("email",
          () -> assertEquals("joseluis.delacruz@gmail.com", email.getEmail(), "Should contains josdem's email"),
          () -> assertTrue(email.isVerified(), "Should be verified"),
          () -> assertTrue(email.isPrimary(), "Should be primary"),
          () -> assertEquals("public", email.getVisibility(), "Should be public")
        );
      }

      @Override
      public void onFailure(Call<List<PublicEmail>> call, Throwable t) {
        log.info("error:", t.getMessage());
      }
    });
  }

}
