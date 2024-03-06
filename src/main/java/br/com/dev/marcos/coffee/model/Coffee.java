package br.com.dev.marcos.coffee.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class Coffee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	//O jersey nos fornece uma forma de validar os componentes através de bean validation
	@NotBlank(message = "O nome não pode estar em branco!")
	private String name;
	
	@NotNull(message = "O Preço deve ser informado!")
	@PositiveOrZero(message = "O preço deve ser igual ou maior que zero!")
	private Double price;
	
	@PastOrPresent(message = "A data de fabricação deve ser menor ou igual a hoje!")
	private LocalDate factoryDate;
	
	@FutureOrPresent(message = "A data de validade deve ser maior ou igual a hoje!")
	private LocalDate expirationDate;
	
	public Coffee() {
		
	}
	
	public Coffee(Long id, 
			@NotBlank(message = "O nome não pode estar em branco!") String name,
			@NotNull(message = "O Preço deve ser informado!") @PositiveOrZero(message = "O preço deve ser igual ou maior que zero!") Double price,
			@PastOrPresent(message = "A data de fabricação deve ser menor ou igual a hoje!") LocalDate factoryDate,
			@FutureOrPresent(message = "A data de validade deve ser maior ou igual a hoje!") LocalDate expirationDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.factoryDate = factoryDate;
		this.expirationDate = expirationDate;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDate getFactoryDate() {
		return factoryDate;
	}
	public void setFactoryDate(LocalDate factoryDate) {
		this.factoryDate = factoryDate;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coffee other = (Coffee) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Coffee [id=" + id + ", name=" + name + ", price=" + price + ", factoryDate=" + factoryDate
				+ ", expirationDate=" + expirationDate + "]";
	}
	
}
