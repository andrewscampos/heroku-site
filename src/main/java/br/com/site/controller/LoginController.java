package br.com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index1() {
		return "index";
	}
	
	@RequestMapping(value = "/sales", method=RequestMethod.GET)
	public void inde() {
	}
	
	@RequestMapping(value = "/teste", method=RequestMethod.POST)
	public void index1s(@RequestBody Object obj) {
		String json = new Gson().toJson(obj);
		System.out.println(json);
	}
	
	public void mantemUsuarioAutenticado(Usuario usuario) {
		Authentication auth = new UsernamePasswordAuthenticationToken(new ResourceOwner(usuario), usuario.getSenha());
		SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(auth));
	}
	public Usuario donoDosLivros() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        ResourceOwner donoDosLivros = (ResourceOwner) authentication.getPrincipal();

       // return usuarios.buscarPorID(donoDosLivros.getId());
        return null;
    }
}
