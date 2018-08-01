package com.jos.dem.retrofit.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.retrofit.workshop.model.PublicEmail;
import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserTest extends UserIntegrationTest {

  @Then("^User gets his public emails$")
  public void shouldGetEmails() throws Exception {
    List<PublicEmail> emails = getEmails();
    PublicEmail email = emails.get(0);

    assertTrue(emails.size() == 1,  () -> "Should be 1 email");
    assertAll("email",
        () -> assertEquals("joseluis.delacruz@gmail.com", email.getEmail(), "Should contains josdem's email"),
        () -> assertTrue(email.isVerified(), "Should be verified"),
        () -> assertTrue(email.isPrimary(), "Should be primary"),
        () -> assertEquals("public", email.getVisibility(), "Should be public")
    );
  }

}
