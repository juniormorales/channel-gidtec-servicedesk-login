package com.pe.gidtec.servicedesk.login.service.impl;

import com.pe.gidtec.servicedesk.login.audit.AuditProperties;
import com.pe.gidtec.servicedesk.login.audit.response.Audit;
import com.pe.gidtec.servicedesk.login.audit.response.StatusCode;
import com.pe.gidtec.servicedesk.login.dao.UsersDao;
import com.pe.gidtec.servicedesk.login.model.entity.UserEntity;
import com.pe.gidtec.servicedesk.login.model.request.LoginRequest;
import com.pe.gidtec.servicedesk.login.model.response.CredentialsResponse;
import com.pe.gidtec.servicedesk.login.model.response.ResultResponse;
import com.pe.gidtec.servicedesk.login.model.response.RoleDTO;
import com.pe.gidtec.servicedesk.login.service.UsersService;
import com.pe.gidtec.servicedesk.login.util.ResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersServiceImpl implements UsersService {

    private final UsersDao usersDao;

    private final AuditProperties auditProperties;

    @Override
    public Mono<ResultResponse<CredentialsResponse>> loginCredentials(LoginRequest request) {
        return usersDao.existsUserByEmailAndPassword(request.getEmail(), request.getPassword())
                .flatMap(bool -> {
                    if (Boolean.TRUE.equals(bool)) {
                        return usersDao.findUserByEmail(request.getEmail())
                                .map(response -> ResultResponse.ok(buildEntityToResponse(response)));
                    } else {
                        return Mono.just(ResultResponse.error(ResponseStatus.BAD_CREDENTIALS));
                    }
                });
    }

    private CredentialsResponse buildEntityToResponse(UserEntity entity) {
        return CredentialsResponse.builder()
                .audit(Audit.builder()
                        .createdBy(entity.getAudit().getCreatedBy())
                        .createdDate(entity.getAudit().getCreatedDate().toString())
                        .deleted(entity.getAudit().getDeleted())
                        .lastModifiedBy(entity.getAudit().getLastModifiedBy())
                        .lastModifiedDate(Objects.nonNull(entity.getAudit().getLastModifiedDate()) ? entity.getAudit().getLastModifiedDate().toString() : null)
                        .status(StatusCode.builder()
                                .code(entity.getAudit().getStatusCode())
                                .description(auditProperties.getStatusCode().get(entity.getAudit().getStatusCode()))
                                .build())
                        .build())
                .companyName(entity.getCompanyName())
                .email(entity.getEmail())
                .lastNames(entity.getLastNames())
                .names(entity.getNames())
                .phoneNumber(entity.getPhoneNumber())
                .webSite(entity.getWebSite())
                .role(RoleDTO.builder()
                        .roleId(entity.getRole().getRoleId())
                        .roleName(entity.getRole().getRoleName())
                        .build())
                .userId(entity.getUserId())
                .build();
    }
}
