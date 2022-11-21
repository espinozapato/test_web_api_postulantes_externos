package com.test_bolsa_santiago.test_bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.test_bolsa_santiago.test_bs.model.Indice;
import com.test_bolsa_santiago.test_bs.service.IndiceService;

@Controller
public class indicesController {

	@Autowired
	private IndiceService indiceService;
	
	@GetMapping("/")
	public String indexIndices(Model m)
	{
		
		List<Indice> instrumentos = indiceService.getIndices();
		if(!instrumentos.isEmpty())
		{   
			m.addAttribute("data", instrumentos);
		}
		else {
			m.addAttribute("msg", "No hay índices disponibles");
		}
		return "indices";
	}
}
