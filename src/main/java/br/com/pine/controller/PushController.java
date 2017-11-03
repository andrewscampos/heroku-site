package br.com.pine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
public class PushController {

	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
		
	@RequestMapping(value="/activity/save",method=RequestMethod.POST)
	public void save(@RequestBody Object object) {
		System.out.println(new Gson().toJson(object));
	}
	@RequestMapping(value="/activity/publish",method=RequestMethod.POST)
	public void publish(@RequestBody Object object) {
		System.out.println(new Gson().toJson(object));
	}
	@RequestMapping(value="/activity/validate",method=RequestMethod.POST)
	public void validate(@RequestBody Object object) {
		System.out.println(new Gson().toJson(object));
	}
	@RequestMapping(value="/activity/execute",method=RequestMethod.POST)
	public void execute(@RequestBody Object object) {
		System.out.println(new Gson().toJson(object));
	}
	
}
