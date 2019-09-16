package br.com.desafiosefaz.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.desafiosefaz.domain.Telefone;

@ManagedBean
public class TelefoneBean implements Serializable {
	
	private Telefone telefones = new Telefone();

	public Telefone getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone telefones) {
		this.telefones = telefones;
	}

}
