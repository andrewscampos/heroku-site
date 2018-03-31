package br.com.site.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.site.bean.Usuario;
import br.com.site.resources.ResourceOwner;

@Service
public class UsuarioService implements UserDetailsService{
	
	private Map<String, Usuario> usuarios = new HashMap<>();
	
	
	@Autowired
	private CryptonService cryptonService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		Optional<Usuario> usuario = Optional.of(usuarios.get(email));

		if (usuario.isPresent()) {
			return new ResourceOwner(usuario.get());
		} else {
			throw new UsernameNotFoundException("usuario não autorizado");
		}
	}
	
	public void cadastrar(Usuario usuario, AuthenticationManager authenticationManager) {
		usuario.setSenha(cryptonService.encrypt(usuario.getSenha(), Algorithms.SHA5));
		usuarios.put(usuario.getEmail(), usuario);
		setSessionUserAuthentication(usuario, authenticationManager);
	}

	private void setSessionUserAuthentication(Usuario usuario, AuthenticationManager authenticationManager) {
		Authentication auth = new UsernamePasswordAuthenticationToken(new ResourceOwner(usuario), usuario.getSenha());
		SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(auth));
	}
	
	public void login(Usuario usuario, AuthenticationManager authenticationManager) throws UsernameNotFoundException {
			Usuario user = usuarios.get(usuario.getNome());
			String password = cryptonService.encrypt(usuario.getSenha(), Algorithms.SHA5);
			if(user != null && user.getSenha().equals(password)) {
				setSessionUserAuthentication(user, authenticationManager);
			}else {
				throw new UsernameNotFoundException("usuario não autorizado");
			}
		
	}
	
	

}
