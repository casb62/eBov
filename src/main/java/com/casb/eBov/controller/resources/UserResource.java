package com.casb.eBov.controller.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.casb.eBov.model.domain.User;

@RestController
@RequestMapping(value="/usuarios")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<User> listar() {
		
		User user1 = new User(1, "joao", "joao123");
		User user2 = new User(2, "maria", "maria123");
		
		List<User> lista = new ArrayList<>();
		lista.add(user1);
		lista.add(user2);
		
		return lista;
	}
}