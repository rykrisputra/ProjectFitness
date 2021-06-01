package com.fitness.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.main.entity.DataUser;
import com.fitness.main.repository.DataUserRepository;


@RestController
@RequestMapping("/user")
public class DataUserController {

	@Autowired
	DataUserRepository dataUserRepo;
	
	@GetMapping("/")
	public List<DataUser> getAll(){
		return dataUserRepo.findAll();
	}
	
	@GetMapping("/login")
	public DataUser loginUser(@RequestParam("username")String username, @RequestParam("hp") String hp) {
		return dataUserRepo.findByLogin(username, hp);
	}
	
	@PostMapping("/register/")
	public String addUser(@RequestBody DataUser user) {
		dataUserRepo.save(user);
		return "Insert Berhasil";
	}
	
	@PostMapping("/register/{id}")
	public String updateUser(@PathVariable String idUser, @RequestBody DataUser user) {
		user.setIdUser(Long.parseLong(idUser));
		dataUserRepo.save(user);
		return "Update Berhasil";
	}
	
}
