package com.jos.dem.retrofit.workshop.model;

public class PublicEmail {
  private String email;
  private boolean verified;
  private boolean primary;
  private String visibility;

  public String getEmail(){
    return email;
  }

  public boolean isVerified(){
    return verified;
  }

  public boolean isPrimary(){
    return primary;
  }

  public String getVisibility(){
    return visibility;
  }




}
