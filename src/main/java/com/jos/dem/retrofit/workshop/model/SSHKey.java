package com.jos.dem.retrofit.workshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SSHKey {
  Long id;
  String key;
}
