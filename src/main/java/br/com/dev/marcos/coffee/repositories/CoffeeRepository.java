package br.com.dev.marcos.coffee.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.dev.marcos.coffee.model.Coffee;

public class CoffeeRepository {

	private static List<Coffee> coffees = new ArrayList<>();
	
	
	static {
		Coffee tresCoracoes = new Coffee.Builder()
										.setId(1L)
										.setName("Café Três Corações")
										.setFactoryDate(LocalDate.now())
										.setExpirationDate(LocalDate.now().plusYears(1))
										.setPrice(20.00)
										.build();
		
		Coffee pilao = new Coffee.Builder()
				.setId(2L)
				.setName("Café Pilão")
				.setFactoryDate(LocalDate.now())
				.setExpirationDate(LocalDate.now().plusYears(1))
				.setPrice(15.00)
				.build();
		
		coffees.addAll(List.of(tresCoracoes, pilao));
	}
	
	public static List<Coffee> findAll() {
		return coffees;
	}

	public static Coffee save(Coffee coffee) {
		System.err.println("Funcionalidade ainda não implementada");
		return null;
	}

	public static boolean delete(long id) {
		System.err.println("Funcionalidade ainda não implementada");
		return false;
	}

	public static Coffee findById(long id) {
		System.err.println("Funcionalidade ainda não implementada");
		return null;
	}
	
	
}
