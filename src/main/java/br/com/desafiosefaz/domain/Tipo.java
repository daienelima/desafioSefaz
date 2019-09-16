package br.com.desafiosefaz.domain;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Tipo {
	FIXO("Fixo"),
	CELULAR("Celular"),
	COMERCIAL("Comercial"),
	OUTROS("Outros");
	
	private String tipo;

	private Tipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public static List<String> getAllTipos(){
		return Arrays.asList(Tipo.values()).stream()
				.map(Tipo::getTipo)
				.collect(Collectors.toList());
	}
	
	public static Tipo getByName(String tipo) {
		 Optional<Tipo> opt = Stream.of(Tipo.values())
				 .filter(i -> i.getTipo().equalsIgnoreCase(tipo))
				 .findFirst();
		 
		 opt.orElseThrow(InvalidParameterException::new);
		 return opt.get();
	}
}
