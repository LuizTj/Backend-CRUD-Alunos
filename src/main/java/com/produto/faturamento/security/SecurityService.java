package com.produto.faturamento.security;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.produto.faturamento.model.Usuario;
import com.produto.faturamento.repository.UsuarioRepository;

@Service
public class SecurityService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuariorepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Usuario usuario = usuariorepository.findByLogin(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("Role_"+ usuario.getRole()));
		
			
		UserDetails userDetails = new User(usuario.getLogin(), usuario.getSenha(), authorities);
		
		return userDetails;
	}
	
	

}
