package com.pe.gidtec.servicedesk.login.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleEntity {

    @Id
    private String roleId;

    @Field(name = "roleName")
    private String roleName;
}
