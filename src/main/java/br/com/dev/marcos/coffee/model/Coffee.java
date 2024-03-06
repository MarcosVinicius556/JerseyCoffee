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
	
	public static class Builder {
		private Long id;
		private String name;
		private Double price;
		private LocalDate factoryDate;
		private LocalDate expirationDate;
		
		public Builder setId(Long id) {
			this.id = id;
			return this;
		}
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setPrice(Double price) {
			this.price = price;
			return this;
		}
		public Builder setFactoryDate(LocalDate factoryDate) {
			this.factoryDate = factoryDate;
			return this;
		}
		public Builder setExpirationDate(LocalDate expirationDate) {
			this.expirationDate = expirationDate;
			return this;
		}
		
		public Coffee build() {
			return new Coffee(this);
		}
		
	}
	
	public Coffee() {
		
	}
	
	public Coffee(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.price = builder.price;
		this.factoryDate = builder.factoryDate;
		this.expirationDate = builder.expirationDate;
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
