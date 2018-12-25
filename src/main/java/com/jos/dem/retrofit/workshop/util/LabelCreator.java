package com.jos.dem.retrofit.workshop.util;

import org.springframework.stereotype.Component;
import com.jos.dem.retrofit.workshop.model.Label;

@Component
public class LabelCreator{

  private Label label = new Label("cucumber", "Cucumber is a very powerful testing framework written in the Ruby programming language","ed14c5");

  public Label create(){
    return label;
  }

}

