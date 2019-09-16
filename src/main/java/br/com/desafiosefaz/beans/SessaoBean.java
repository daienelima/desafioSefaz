package br.com.desafiosefaz.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SessaoBean implements Serializable{
	
	private String email;
	private String senha;
	
	public String login(){
		if(email.equalsIgnoreCase("teste@gmail.com") && senha.equals("123456")){
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usuário logado", "Usuário Logado"));
			return "/index.jsf?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha errados!", "Usuário ou senha errados!"));
			return "";
		}
			
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
