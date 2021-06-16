package com.fitness.main.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fitness.main.entity.DataUser;
import com.fitness.main.repository.DataUserRepository;
import com.fitness.main.utility.FileUtility;
import com.google.gson.Gson;


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
	
	@PostMapping("/")
	public String addUser(@RequestParam(value = "file") MultipartFile images,@ModelAttribute(value="data")String dataJSON) throws IOException{
		String fileName = StringUtils.cleanPath(images.getOriginalFilename());
		
		String uploadDir = "src/main/java/user-photo/";
		FileUtility.saveFile(uploadDir, fileName, images);
		DataUser user= new Gson().fromJson(dataJSON, DataUser.class);
		
		user.setImage(fileName);
		dataUserRepo.save(user);
		return "Berhasil memasukan data";
	}
	
	@PostMapping("/register/{id}")
	public String updateUser(@PathVariable String idUser, @RequestBody DataUser user) {
		user.setIdUser(Long.parseLong(idUser));
		dataUserRepo.save(user);
		return "Update Berhasil";
	}
	
	
	@GetMapping(value = "/image/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable String name) throws IOException {
	   final InputStream in = getClass().getResourceAsStream("/user-photo/"+name);
	   return IOUtils.toByteArray(in);
	}
	
}
