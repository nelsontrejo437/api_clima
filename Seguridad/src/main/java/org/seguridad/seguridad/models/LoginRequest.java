package org.seguridad.seguridad.models;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
