package com.jos.dem.retrofit.workshop.service;

import reactor.core.publisher.Flux;
import com.jos.dem.retrofit.workshop.model.SSHKey;
import com.jos.dem.retrofit.workshop.model.PublicEmail;

public interface UserService {

  Flux<PublicEmail> getEmails();

}
