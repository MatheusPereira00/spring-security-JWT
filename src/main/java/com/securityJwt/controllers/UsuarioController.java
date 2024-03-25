package com.securityJwt.controllers;

import com.securityJwt.dtos.UsuarioDto;
import com.securityJwt.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/admin")
    private String getAdmin(){ return "Permissão de administrador"; }

    @GetMapping("/user")
    private String getUser(){ return "Permissão de usuario"; }

}
