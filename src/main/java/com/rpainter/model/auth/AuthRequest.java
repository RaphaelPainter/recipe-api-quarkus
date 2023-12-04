package com.rpainter.model.auth;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@RegisterForReflection
@Setter
@Getter
public class  AuthRequest {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String username;
    public String password;
}