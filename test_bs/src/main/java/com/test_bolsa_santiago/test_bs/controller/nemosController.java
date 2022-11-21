package com.test_bolsa_santiago.test_bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.test_bolsa_santiago.test_bs.model.InstrumentosValidos;
import com.test_bolsa_santiago.test_bs.service.InstrumentosValidosService;

@Controller
public class nemosController {
	
	@Autowired
	private InstrumentosValidosService instrumentosService;
	
	@GetMapping("/nemos")
	public String indexNemos(Model m)
	{
		
		List<InstrumentosValidos> instrumentos =  instrumentosService.getInstrumentosValidos();
		if(!instrumentos.isEmpty())
		{   
			m.addAttribute("data", instrumentos);
		}
		else {
			m.addAttribute("msg", "Nemos no disponibles");
		}
		return "nemos";
	}
}
