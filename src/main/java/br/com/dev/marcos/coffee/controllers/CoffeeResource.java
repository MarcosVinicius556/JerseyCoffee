package br.com.dev.marcos.coffee.controllers;

import java.net.URI;
import java.util.List;

import br.com.dev.marcos.coffee.model.Coffee;
import br.com.dev.marcos.coffee.repositories.CoffeeRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.UriBuilder;

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
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Coffee coffee) {
		Coffee obj = CoffeeRepository.save(coffee);

		//Após salvar, como boa prática, retornamos a URL de busca para a entidade salva
		final URI coffeeURI = UriBuilder.fromResource(CoffeeResource.class).path("/coffee/{id}").build(obj.getId());
		
		ResponseBuilder response = Response.created(coffeeURI); //Criando retorno 201
		response.entity(obj); //Definindo o conteudo do retorno
		
		return response.build(); // Gera o retorno
	}
}
