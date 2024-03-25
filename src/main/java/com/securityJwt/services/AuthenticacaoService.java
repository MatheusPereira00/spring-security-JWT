package com.securityJwt.services;

import com.securityJwt.dtos.AuthDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticacaoService extends UserDetailsService {

    public String obterToken(AuthDto authDto);

    public String validaTokenJwt(String token);

}
