package com.pe.gidtec.servicedesk.login.model.entity;

import com.pe.gidtec.servicedesk.login.audit.entity.AuditEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {

    @Id
    @Field(name= "user_id")
    private String userId;

    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;

    @Field(name = "names")
    private String names;

    @Field(name = "last_names")
    private String lastNames;

    @Field(name = "phone_number")
    private String phoneNumber;

    @Field(name = "company_name")
    private String companyName;

    @Field(name = "web_site")
    private String webSite;

    @Field(name = "role")
    private RoleEntity role;

    private AuditEntity audit;
}
