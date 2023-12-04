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
public class AuthResponse {
    String accessToken;

    public AuthResponse(String s) {
        accessToken = s;
    }
}