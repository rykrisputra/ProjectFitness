package com.fitness.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.main.entity.DataUser;
import com.fitness.main.entity.History;
import com.fitness.main.repository.HistoryRepository;

@RestController
@RequestMapping("/history")
public class HistoryController {

	@Autowired
	HistoryRepository historyRepo;
	
	@GetMapping("/")
	public List<History> getAll(){
		return historyRepo.findAll();
	}
	
	@PostMapping("/post/")
	public String addHistory(@RequestBody History history) {
		historyRepo.save(history);
		return "Insert Berhasil";
	}
}
