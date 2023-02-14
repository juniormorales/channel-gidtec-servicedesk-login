package com.pe.gidtec.servicedesk.login.repository;

import com.pe.gidtec.servicedesk.login.model.entity.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UsersRepository extends ReactiveMongoRepository<UserEntity,String> {

    Mono<Boolean> existsUserEntityByEmailAndPasswordAndAuditDeletedFalse(String email, String password);

    Mono<UserEntity> findUserEntityByEmailAndAuditDeletedFalse(String email);
}
