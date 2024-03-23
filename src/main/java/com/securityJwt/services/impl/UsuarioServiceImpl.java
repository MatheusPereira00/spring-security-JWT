package com.securityJwt.services.impl;

import com.securityJwt.dtos.UsuarioDto;
import com.securityJwt.models.Usuario;
import com.securityJwt.repositories.UsuarioRepository;
import com.securityJwt.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto) {

        Usuario UsuarioJaExiste = usuarioRepository.findByLogin(usuarioDto.login());
        if(UsuarioJaExiste != null){
            throw new RuntimeException("Usuario já cadastrado na base de dados, verifique seu login por favor!");
        }

        Usuario entity = new Usuario(usuarioDto.nome(), usuarioDto.login(), usuarioDto.senha());
        Usuario novoUsuario = usuarioRepository.save(entity);
        return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getLogin(), novoUsuario.getSenha());
    }
}
