package com.test_bolsa_santiago.test_bs.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.test_bolsa_santiago.test_bs.model.InstrumentosValidos;


@Configuration
public class InstrumentosValidosImpl implements InstrumentosValidosService {
	
	private static final String url_instrumentos_validos = "https://startup.bolsadesantiago.com/api/consulta/InstrumentosDisponibles/getInstrumentosValidos?access_token=";
    private final RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public List<InstrumentosValidos> getInstrumentosValidos() {
		ResponseEntity<JsonObject> responseEntity =
		          restTemplate.exchange(
		        	url_instrumentos_validos,
		            HttpMethod.POST,
		            null,
		            JsonObject.class
		          );
				JsonObject instrumentos = responseEntity.getBody();
				List<InstrumentosValidos> nemos = (List<InstrumentosValidos>) instrumentos.get("listaResult");
		return nemos;
	}

}
