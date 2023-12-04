package com.rpainter.model.auth;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.Set;



@NoArgsConstructor
@ToString
@RegisterForReflection
@Setter
@Getter
public class AuthUser {


    public AuthUser(String username, String password, Set<AuthRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String username;
    public String password;
    public Set<AuthRole> roles;

    // this is just an example, you can load the user from the database (via PanacheEntityBase)
    public static AuthUser findByUsername(String username) {

        String userUsername = "user";

        //generated from password encoder
        String userPassword = "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=";

        String adminUsername = "admin";

        //generated from password encoder
        String adminPassword = "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=";

        if (username.equals(userUsername)) {
            return new AuthUser(userUsername, userPassword, Collections.singleton(AuthRole.USER));
        } else if (username.equals(adminUsername)) {
            return new AuthUser(adminUsername, adminPassword, Collections.singleton(AuthRole.ADMIN));
        } else {
            return null;
        }
    }
}