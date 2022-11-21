package com.test_bolsa_santiago.test_bs.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.test_bolsa_santiago.test_bs.model.Indice;

@Configuration
public class IndiceImpl implements IndiceService {
	private static final String url_instrumentos_validos = "https://startup.bolsadesantiago.com/api/consulta/TickerOnDemand/getIndices?access_token=";
    private final RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public List<Indice> getIndices() {
		ResponseEntity<JsonObject> responseEntity =
		          restTemplate.exchange(
		        	url_instrumentos_validos,
		            HttpMethod.POST,
		            null,
		            JsonObject.class
		          );
				JsonObject indicesJson = responseEntity.getBody();
				List<Indice> indices = (List<Indice>) indicesJson.get("listaResult");
		return indices;
	}
}
