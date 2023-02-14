package com.pe.gidtec.servicedesk.login.dao;

import com.pe.gidtec.servicedesk.login.model.entity.UserEntity;
import reactor.core.publisher.Mono;

public interface UsersDao {

    Mono<Boolean> existsUserByEmailAndPassword(String email, String password);

    Mono<UserEntity> findUserByEmail(String email);
}
