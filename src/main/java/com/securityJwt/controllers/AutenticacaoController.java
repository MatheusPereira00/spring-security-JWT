package com.securityJwt.controllers;

import com.securityJwt.dtos.AuthDto;
import com.securityJwt.services.AuthenticacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;
    private AuthenticacaoService authenticacaoService;

    public AutenticacaoController(AuthenticationManager authenticationManager, AuthenticacaoService authenticacaoService) {
        this.authenticationManager = authenticationManager;
        this.authenticacaoService = authenticacaoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public  String auth(@RequestBody AuthDto authDto){
        var usuarioAuthenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.senha());
        authenticationManager.authenticate(usuarioAuthenticationToken);
        return authenticacaoService.obterToken(authDto);
    }

}
