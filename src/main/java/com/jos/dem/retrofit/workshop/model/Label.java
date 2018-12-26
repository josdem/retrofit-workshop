package com.jos.dem.retrofit.workshop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Label {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("description")
  @Expose
  private String description;
  @SerializedName("color")
  @Expose
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

