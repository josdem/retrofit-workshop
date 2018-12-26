package com.jos.dem.retrofit.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.retrofit.workshop.model.LabelResponse;
import com.jos.dem.retrofit.workshop.service.LabelService;
import com.jos.dem.retrofit.workshop.util.LabelCreator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelCreateTest extends LabelIntegrationTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private LabelService labelService;
  @Autowired
  private LabelCreator labelCreator;

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @Then("User creates a new label")
  public void shouldCreateLabel() throws Exception {
    log.info("Running: User creates a new label");

    Call<LabelResponse> call = labelService.create(labelCreator.create());
    call.enqueue(new Callback<LabelResponse>() {

      @Override
      public void onResponse(Call<LabelResponse> call, Response<LabelResponse> response){
        LabelResponse label = response.body();

        log.info("response:" + ToStringBuilder.reflectionToString(response));
        log.info("label:" + ToStringBuilder.reflectionToString(label));
        assertAll("response",
            () -> assertEquals("cucumber", label.getName()),
            () -> assertEquals("ed14c5", label.getColor())
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

