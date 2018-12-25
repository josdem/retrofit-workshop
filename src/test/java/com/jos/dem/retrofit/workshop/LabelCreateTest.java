package com.jos.dem.retrofit.workshop;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.springframework.beans.factory.annotation.Autowired;

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

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}

