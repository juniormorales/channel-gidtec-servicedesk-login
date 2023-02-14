package com.pe.gidtec.servicedesk.login.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {

    OK("00", "Se ha iniciado sesión correctamente."),
    BAD_CREDENTIALS("01","Las credenciales ingresadas son incorrectas.");

    private final String code;
    private final String description;
}
