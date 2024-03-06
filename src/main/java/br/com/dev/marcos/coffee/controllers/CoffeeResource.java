package br.com.dev.marcos.coffee.controllers;

import java.util.List;

import br.com.dev.marcos.coffee.model.Coffee;
import br.com.dev.marcos.coffee.repositories.CoffeeRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/coffees")
public class CoffeeResource {

	@GET //Método HTTP de acesso
	@Produces(MediaType.APPLICATION_JSON) //Tipo de retorno
	public Response findAll() {
		List<Coffee> coffees = CoffeeRepository.findAll();
		ResponseBuilder response = Response.ok(); //Criando retorno OK
		response.entity(coffees); //Definindo o conteudo do retorno
		
		return response.build(); // Gera o retorno
	}
}
