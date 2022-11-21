package com.test_bolsa_santiago.test_bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test_bolsa_santiago.test_bs.model.Indice;
import com.test_bolsa_santiago.test_bs.service.IndiceService;

@RestController
public class indicesRestController {
	
	@Autowired
	private IndiceService indiceService;
	
	@GetMapping("/allIndices")
	public List<Indice> restIndices(){
		return indiceService.getIndices();
	}
}
