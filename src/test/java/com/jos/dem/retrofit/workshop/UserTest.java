package com.jos.dem.retrofit.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.retrofit.workshop.model.PublicEmail;
import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTest extends UserIntegrationTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Then("^User gets his public emails$")
  public void shouldGetEmails() throws Exception {
    List<PublicEmail> emails = getEmails();

    log.info("Validating collection integrity");
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

}
