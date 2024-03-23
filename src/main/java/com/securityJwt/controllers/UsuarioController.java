package com.securityJwt.controllers;

import com.securityJwt.dtos.UsuarioDto;
import com.securityJwt.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    private UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto){
        return usuarioService.salvar(usuarioDto);
    }
}
