package br.com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.site.annotations.Open;
import br.com.site.bean.Usuario;
import br.com.site.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioService service;
	
	@Open
	@RequestMapping(value = {"/","/login"}, method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	
	@Open
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(Usuario usuario) {
		service.login(usuario, authenticationManager);
		return "home";
	}
	
	
	
	
	
	
	public Usuario donoDosLivros() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        ResourceOwner donoDosLivros = (ResourceOwner) authentication.getPrincipal();
        return new Usuario();
//        return usuarios.buscarPorID(donoDosLivros.getId());
    }
}
