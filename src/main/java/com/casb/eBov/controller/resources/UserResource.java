package com.casb.eBov.controller.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casb.eBov.model.domain.User;
import com.casb.eBov.model.services.UserService;

@RestController
@RequestMapping(value="/usuarios")
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		User obj = service.bring(id);
		return ResponseEntity.ok().body(obj);
	}
}