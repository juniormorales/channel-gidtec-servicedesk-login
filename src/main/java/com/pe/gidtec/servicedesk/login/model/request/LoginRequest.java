package com.pe.gidtec.servicedesk.login.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "LoginRequest")
public class LoginRequest {

    @NotBlank
    @Schema(name = "email",
            description = "Email del usuario que inicia sesión.",
            example = "user1@gidtec.com.pe")
    private String email;

    @NotBlank
    @Schema(name = "password",
            description = "Contraseña del usuario que inicia sesión.",
            example = "123abRD%")
    private String password;
}
