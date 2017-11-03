package br.com.pine.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pine.bean.Push;

@Controller
public class PushController {

	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/sendPush",method=RequestMethod.POST)
	public void sendPush(@RequestBody @Valid Push push) {
		System.out.println(push);
	}
}
