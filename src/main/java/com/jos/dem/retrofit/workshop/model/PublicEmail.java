package com.jos.dem.retrofit.workshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicEmail {
  private String email;
  private boolean verified;
  private boolean primary;
  private String visibility;
}
