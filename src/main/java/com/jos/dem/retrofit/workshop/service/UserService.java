package com.jos.dem.retrofit.workshop.service;

import reactor.core.publisher.Flux;
import com.jos.dem.webclient.model.SSHKey;
import com.jos.dem.webclient.model.PublicEmail;

public interface UserService {

  Flux<PublicEmail> getEmails();

}
