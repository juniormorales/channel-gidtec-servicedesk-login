package com.pe.gidtec.servicedesk.login.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name= "RoleDTO")
public class RoleDTO {

    @Schema(name = "roleId",
            description = "Identificador del rol",
            example = "1ab24sof5e1vxc")
    private String roleId;

    @Schema(name = "roleName",
            description = "Nombre del rol",
            example = "ADMIN")
    private String roleName;

}
