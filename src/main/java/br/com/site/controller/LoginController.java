package br.com.site.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class LoginController {

//	@Autowired
//	private AuthenticationManager authenticationManager;
	
	List<String> list = new ArrayList<>();
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index1() {
		return "index";
	}
	
	@RequestMapping(value = "/sales", method=RequestMethod.GET)
	public @ResponseBody String inde() {
		return "";
	}
	
	@RequestMapping(value = "/teste", method=RequestMethod.POST)
	public void index1s(@RequestBody Map obj) {
		String json = new Gson().toJson(obj);
		list.add(json);
	}
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public @ResponseBody List<String> index1s() {
		return list;
	}
	
//	public void mantemUsuarioAutenticado(Usuario usuario) {
//		Authentication auth = new UsernamePasswordAuthenticationToken(new ResourceOwner(usuario), usuario.getSenha());
//		SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(auth));
//	}
	public Usuario donoDosLivros() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        ResourceOwner donoDosLivros = (ResourceOwner) authentication.getPrincipal();

       // return usuarios.buscarPorID(donoDosLivros.getId());
        return null;
    }
}
