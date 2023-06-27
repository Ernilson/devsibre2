/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devsibre.ConfigWebSecurity;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.devsibre.Model.Usuario;
import br.com.devsibre.Repository.UsuarioRepository;

/**
 *
 * @author Convidado
 */
@Repository
@Transactional
public class ImplementsUserDetaisService implements UserDetailsService {

    @Autowired
    private UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = ur.findByLogin(login);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
    }

}
