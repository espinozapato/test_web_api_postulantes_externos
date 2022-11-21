package com.test_bolsa_santiago.test_bs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class graficosController {
	
	@GetMapping("/graficos")
	public String indexGraficos()
	{
		return "graficos";
	}
}
