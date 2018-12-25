package com.jos.dem.retrofit.workshop;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.retrofit.workshop.model.LabelResponse;
import com.jos.dem.retrofit.workshop.service.LabelService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelCreateTest extends LabelIntegrationTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private LabelService labelService;

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @Then("User creates a new label")
  public void shouldCreateLabel() throws Exception {
    log.info("Running: User creates a new label");

    Call<LabelResponse>> call = labelService.create();
    call.enqueue(new retrofit2.Callback<LabelResponse>() {

      @Override
      public void onResponse(Call<LabelResponse> call, Response<LabelResponse>> response){
        LabelResponse label = response.body();

        assertAll("response",
            () -> assertEquals("cucumber", response.getName()),
            () -> assertEquals("ed14c5", response.getColor())
        );
      }

      @Override
      public void onFailure(Call<LabelResponse> call, Throwable t) {
        log.info("error:", t.getMessage());
      }

    });
  }


  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}

