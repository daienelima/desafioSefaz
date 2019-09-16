package br.com.desafiosefaz.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.desafiosefaz.domain.Tipo;

@Named
@RequestScoped
public class DataBean {
	
	public List<String> getTipos() {
		return Tipo.getAllTipos();
	}
}
