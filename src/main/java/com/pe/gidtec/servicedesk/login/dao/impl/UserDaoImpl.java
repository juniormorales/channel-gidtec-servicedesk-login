package com.pe.gidtec.servicedesk.login.dao.impl;

import com.pe.gidtec.servicedesk.login.dao.UsersDao;
import com.pe.gidtec.servicedesk.login.model.entity.UserEntity;
import com.pe.gidtec.servicedesk.login.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDaoImpl implements UsersDao {

    private final UsersRepository usersRepository;

    @Override
    public Mono<Boolean> existsUserByEmailAndPassword(String email, String password) {
        return usersRepository.existsUserEntityByEmailAndPasswordAndAuditDeletedFalse(email,password);
    }

    @Override
    public Mono<UserEntity> findUserByEmail(String email) {
        return usersRepository.findUserEntityByEmailAndAuditDeletedFalse(email);
    }
}
