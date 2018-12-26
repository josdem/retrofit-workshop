package com.jos.dem.retrofit.workshop.model;

import lombok.Data;
import lombok.AllArgsConstructor;

public class Label {
  private String name;
  private String description;
  private String color;

  public Label(String name, String description, String color){
    this.name = name;
    this.description = description;
    this.color = color;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public String getDescription(){
    return description;
  }

  public void setColor(String color){
    this.color = color;
  }

  public String getColor(){
    return color;
  }

}

