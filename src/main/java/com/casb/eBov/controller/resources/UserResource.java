package com.casb.eBov.controller.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/usuarios")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest está funcionando. Que bacana!";
	}
}
