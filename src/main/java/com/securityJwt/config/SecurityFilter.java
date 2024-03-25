package com.securityJwt.config;

import com.securityJwt.models.Usuario;
import com.securityJwt.repositories.UsuarioRepository;
import com.securityJwt.services.AuthenticacaoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private AuthenticacaoService authenticacaoService;
    private UsuarioRepository usuarioRepository;

    public SecurityFilter(AuthenticacaoService authenticacaoService, UsuarioRepository usuarioRepository) {
        this.authenticacaoService = authenticacaoService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = extraiTokenHeader(request);

        if(token != null){
            String login = authenticacaoService.validaTokenJwt(token);
            Usuario usuario = usuarioRepository.findByLogin(login);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    public String extraiTokenHeader(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");

        if(authHeader == null){
            return null;
        }

        // BEARER XXXXXXXXXXX

        if(authHeader.split("")[0].equals("Bearer")){
            return null;
        }

        return authHeader.split("")[1];
    }
}
