package com.securityJwt.dtos;


import com.securityJwt.enums.RoleEnum;

public record UsuarioDto(

        String nome,
        String login,
        String senha,
        RoleEnum role
) {
}
