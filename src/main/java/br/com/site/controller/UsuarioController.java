package br.com.site.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.site.annotations.Open;
import br.com.site.bean.Usuario;
import br.com.site.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Open
	@RequestMapping(value = "/cadastrar", method=RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario) {
		usuarioService.cadastrar(usuario,authenticationManager);
		return "redirect:/home";
	}
	
	@Open
	@RequestMapping(value = "/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	@Open
	@RequestMapping(value= {"/reset/password","/password"})
	public String reset() {
		return "password";
	}
	
	
	@Open
	@RequestMapping(value="/send/password",method=RequestMethod.POST)
	public String resetPassword(String email) {
		return "redirect:/password";
	}
}



