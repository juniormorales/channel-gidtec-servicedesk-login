package com.pe.gidtec.servicedesk.login.service;

import com.pe.gidtec.servicedesk.login.model.request.LoginRequest;
import com.pe.gidtec.servicedesk.login.model.response.CredentialsResponse;
import com.pe.gidtec.servicedesk.login.model.response.ResultResponse;
import reactor.core.publisher.Mono;

public interface UsersService {

    Mono<ResultResponse<CredentialsResponse>> loginCredentials(LoginRequest request);
}
