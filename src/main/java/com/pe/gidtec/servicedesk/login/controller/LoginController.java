package com.pe.gidtec.servicedesk.login.controller;

import com.pe.gidtec.servicedesk.login.model.request.LoginRequest;
import com.pe.gidtec.servicedesk.login.model.response.CredentialsResponse;
import com.pe.gidtec.servicedesk.login.model.response.ResultResponse;
import com.pe.gidtec.servicedesk.login.service.UsersService;
import com.pe.gidtec.servicedesk.login.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/channel/api/login")
@Tag(name = "Login", description = "Permite el inicio de sesión de usuarios")
@Validated
public class LoginController {

    private final UsersService usersService;

    private final ResponseUtil responseUtil;

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Proceso Satisfactorio.",
                    content = @Content(schema = @Schema(implementation = CredentialsResponse.class)))
    },
            summary = "Permite el inicio de sesión de un usuario",
            method = "POST")
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<ResponseEntity<ResultResponse<CredentialsResponse>>> login(
            @Validated
            @RequestBody
                    LoginRequest request
    ) {
        return usersService.loginCredentials(request)
                .map(responseUtil::getResponseEntityStatus);
    }
}
